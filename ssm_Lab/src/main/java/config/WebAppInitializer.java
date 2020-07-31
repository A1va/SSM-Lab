package config;
/*
 * Created by Nolva on 2020/5/27.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);

    /**
     * 指定 Root WebApplicationContext 类，这个类必须@Configuration来注解，从而代替XML配置文件
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        LOG.info("------SpringRoot配置类初始化------");
        return new Class<?>[]{ RootConfig.class, /* WebSecurityConfig.class */ };
    }

    /**
     * 指定 Servlet WebApplicationContext 类，这个类必须@Configuration来注解，从而代替XML配置文件
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        LOG.info("------SpringWeb配置类初始化------");
        return new Class<?>[]{ WebConfig.class };
    }

    /**
     * 指定 Servlet mappings
     */
    @Override
    protected String[] getServletMappings() {
        LOG.info("------映射路径初始化------");
//        将DispatcherServlet映射到"/"
        return new String[]{ "/" };
    }

    /**
     * 配置servlet过滤器
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{characterEncodingFilter()};
    }

    /**
     * 当registerDispatcherServlet完成时自定义registration
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
        registration.setInitParameter("spring.profiles.active", "default");
    }

    /**
     * 字符集过滤器
     * @return
     */
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        //字符集过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

}
