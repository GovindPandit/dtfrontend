package com.niit.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages="com.niit")
//@ComponentScan(basePackages="com.niit.controller")
@ComponentScan(basePackages="com.niit.*")
public class AppContext extends WebMvcConfigurerAdapter
{
	
//	@Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/loginpage").setViewName("loginpage");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }
//	
//	 @Bean(name="multipartResolver") 
//	    public CommonsMultipartResolver getResolver() {
//	        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//	         
//	        //Set the maximum allowed size (in bytes) for each individual file.
//	        resolver.setMaxUploadSizePerFile(5242880);//5MB
//	         
//	        //You may also set other available properties.
//	         
//	        return resolver;
//	    }
//	 
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) 
	   {
	       registry.addResourceHandler("/images/**") 
	                 .addResourceLocations("/WEB-INF/resources/images/");
	       registry.addResourceHandler("/css/**") 
           			.addResourceLocations("/WEB-INF/resources/css/");
	       registry.addResourceHandler("/js/**") 
  					.addResourceLocations("/WEB-INF/resources/js/");
	       registry.addResourceHandler("/videos/**") 
					.addResourceLocations("/WEB-INF/resources/videos/");
	       registry.addResourceHandler("/data1/**") 
			.addResourceLocations("/WEB-INF/resources/data1/");
	       registry.addResourceHandler("/engine1/**") 
			.addResourceLocations("/WEB-INF/resources/engine1/");
	       registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/*");
	   }
	 
	    
	   @Override
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 
	   {
	       configurer.enable();
	   }
}