package com.robb1e.helloworld

import org.springframework.context.annotation.{Bean, ComponentScan, Configuration}
import org.springframework.web.servlet.config.annotation.{EnableWebMvc, WebMvcConfigurerAdapter}
import org.springframework.web.servlet.view.{InternalResourceViewResolver, JstlView}

@Configuration @EnableWebMvc @ComponentScan(basePackages = Array("com.robb1e.helloworld"))
class Config extends WebMvcConfigurerAdapter {

    @Bean
    def viewResolver() = {
        val viewResolver = new InternalResourceViewResolver
        viewResolver.setViewClass(classOf[JstlView])
        viewResolver.setPrefix("/WEB-INF/views/")
        viewResolver.setSuffix(".jsp")
        viewResolver;
    }

}
