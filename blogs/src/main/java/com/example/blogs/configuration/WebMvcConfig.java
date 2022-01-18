package com.example.blogs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author otaku
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    InterceptorConfig interceptorConfig;

    public WebMvcConfig(InterceptorConfig interceptorConfig){
        this.interceptorConfig=interceptorConfig;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/META-INF/swagger-ui/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptorConfig)
                //新增拦截目录
                .addPathPatterns("/**")
                //移除拦截目录
                .excludePathPatterns("");
    }
}
