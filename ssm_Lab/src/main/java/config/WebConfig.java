package config;
/*
 * Created by Nolva on .
 */

import com.interceptor.LoginInterceptor;
import com.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 这里对于MvcConfig的建议采用实现WebMvcConfigurer接口来重写configureDefaultServletHandling方法，其实还有通过继承WebMvcConfigurationSupport类重写这个方法的，但是我自己使用的时候有遇到过这种情况下重写不生效的情况，网上也有和我同样问题，最后换成实现接口的方式就解决这个问题。
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置jsp视图解析器
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
//        可以在JSP页面中通过${}访问beans
        resolver.setExposeContextBeansAsAttributes(true);
        resolver.setViewClass(JstlView.class);

        return resolver;
    }



    /**
     * 跳过静态资源
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        配置静态资源的处理
        configurer.enable();
    }

    /**
     * 手动添加资源路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("/statics/");
    }


//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new
//    }

    /**
     * 字符串消息转换器
     * @return
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    /**
     * 避免IE执行AJAX时，返回JSON出现下载文件
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        MediaType html = new MediaType("text", "html", Charset.forName("UTF-8"));
        List<MediaType> medias = new ArrayList<>();
        medias.add(html);
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(medias);
        return mappingJackson2HttpMessageConverter;
    }

    /**
     * 注册消息转换器
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
    }

    /**
     * 配置自定义的拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new BaseInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/*", "/permission/*", "/role/*", "/sysLog/*", "/department/*", "/position/*").excludePathPatterns("/", "/login", "/userInfo", "/dashboard", "");
    }


    /**
     * 配置文件上传
     * @return
     */
//    @Bean
//    public MultipartResolver multipartResolver() {
//        return new StandardServletMultipartResolver();
//    }
}
