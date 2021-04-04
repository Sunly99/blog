package blog.common.config;

import blog.common.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author 挽风
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        // 添加对用户未登录的拦截器，并添加排除项
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/manager/**")
                .excludePathPatterns(
                        "/manager/css/**",
                        "/manager/fonts/**",
                        "/manager/images/**",
                        "/manager/js/**",
                        "/manager/favicon.ico"
                ).excludePathPatterns("/uploadFile/**");
    }

}
