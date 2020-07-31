package config;
/*
 * Created by Nolva on .
 */

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 主要配置持久层的一些东西，包括数据库、Mybatis框架，事务之类的东西
 */
@Aspect
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = "com.dao", sqlSessionFactoryRef = "sqlSessionFactory")
@ComponentScan(basePackages = {"com.dao", "com.service"})
public class RootConfig {

//    得到一个用来记录日志的对象，这样在打印信息的时候能够标记打印的是哪个类的信息
    private Logger LOG = LoggerFactory.getLogger(RootConfig.class);

    /**
     * 必须返回一个 PropertySourcesPlaceholderConfigurer 的bean,
     * 否则,会不能识别@Value("${userBean.name}") 注解中的 ${userBean.name}指向的value,
     * 而会注入${userBean.name}的字符串
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 读取jdbc.properties文件里面的值配置数据库
     * @param driver
     * @param url
     * @param username
     * @param password
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource(@Value("${jdbc.driver}")String driver,
                                 @Value("${jdbc.url}")String url,
                                 @Value("${jdbc.username}")String username,
                                 @Value("${jdbc.password}")String password){
        LOG.info("初始化数据库连接池...");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    /**
     * 定义Mybatis的SessionFactory，配置mybatis-config.xml配置文件的位置信息
     * @param dataSource
     * @return
     */
    @Autowired
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){

//        SqlSessionFactory
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
//        mybatis分页
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
//        配置数据库为mysql
        properties.setProperty("helperDialect", "mysql");
//        分页尺寸为0时 查询所有记录不再执行分页
        properties.setProperty("pageSizeZero", "true");
//        页码<=0 查询第一页，页码>=总页数 查询最后一页
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        factory.setPlugins(new Interceptor[]{pageInterceptor});

        return factory;
    }

    /**
     * 用于创建事务管理器对象
     * @param dataSource
     * @return
     */
    @Autowired
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


    //切入点配置
    @Pointcut("execution(* com.service.impl.*.*(..))")
    private void pt(){}

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around("pt()")
    public Object transactionAround(ProceedingJoinPoint pjp){
        Object returnValue = null;
//        获取当前方法名称
        String methodName = pjp.getSignature().getName();
        try {
            //获取方法执行所需的参数
            Object[] args = pjp.getArgs();
            //前置通知
            System.out.println("前置通知");
            //执行方法
            returnValue = pjp.proceed(args);
            LOG.info("正在执行：");
            System.out.println("后置通知, " + methodName + "方法执行完成！");
        }catch (Throwable t){
            System.out.println("异常通知, " + methodName + "方法出现异常！");
            throw new RuntimeException(t);
        }finally {
            System.out.println("最终通知");
        }
        return returnValue;
    }


}
