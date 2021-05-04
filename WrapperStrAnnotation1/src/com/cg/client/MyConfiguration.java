package com.cg.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com")
// it scans annotations @component,@Service,@Controller,@RestController
//@Repository
// under com package having annotated component find classes
//@PropertySource("calsspath:cg.properties")
public class MyConfiguration {
	
//	Environment env;
	@Bean
	public PropertySourcesPlaceholderConfigurer getPlaceholder() {
//		PropertySource new PropertySourcesPlaceholderConfigurer();
		PropertySourcesPlaceholderConfigurer holder = new PropertySourcesPlaceholderConfigurer();
		holder.setLocation(new ClassPathResource("cg.properties"));
		return holder;
		
	}

}
