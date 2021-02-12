package com.sagar.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@WebAppConfiguration
@ComponentScan(basePackages = "com.sagar.controller")
public class SpringApplicationConfig implements WebMvcConfigurer {

/*@Bean
    public InternalResourceViewResolver viewResolverw(){
        InternalResourceViewResolver vw = new InternalResourceViewResolver();
        vw.setPrefix("/WEB-INF/jsp/");
        vw.setSuffix(".jsp");
        return vw;
    }*/

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsp/",".jsp");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/statics/");
    }

}
