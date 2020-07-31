//package config;
///*
// * Created by Nolva on 2020/6/30.
// */
//
//import com.service.IUserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity  // 启用web安全功能
////@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);
//
//    private final DataSource dataSource;
//    @Qualifier
//    private final IUserService userService;
//
////    配置自定义的用户服务（即选择用户信息的查询方式是从用户库或数据库，怎么查询）
//    @Autowired
//    public WebSecurityConfig(DataSource dataSource, IUserService userService) {
//        this.dataSource = dataSource;
//        this.userService = userService;
//    }
//
//    /**
//     * 密码加密
//     */
//    @Bean("passwordEncoder")
//    public static PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userService);
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/statics/**");
//    }
//
//
//    /**
//     * 代替xml：
//     * <http>
//     *     <intercept-url pattern="/**" access="isAuthenticated()"/>
//     *     <form-login />
//     *     <http-basic />
//     * </http>
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                    .anyRequest()
////                        .permitAll()
//                        .authenticated()
////                        .access("hasRole('ADMIN') and hasRole('USER')")
//                    .and()
//                .formLogin()
//                    .loginPage("/login.jsp")
//                    .loginProcessingUrl("/login")
//                    .failureForwardUrl("/login.jsp")
//                    .permitAll()
//                    .successForwardUrl("/dashboard")
//                    .and()
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/login.jsp")
//                    .invalidateHttpSession(true);
////                    如果(默认)开启了CSRF，退出则需要使用POST访问，可使用以下方式解决，但不推荐
////                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//    }
//
//}
