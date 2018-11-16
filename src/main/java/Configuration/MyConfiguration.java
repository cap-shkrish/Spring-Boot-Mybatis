package Configuration;


import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Processor.MyBeanPostProcessor;




@Configuration
public class MyConfiguration {

	@Bean
	public BeanPostProcessor postProcessBeforeInitialization(){
		return new MyBeanPostProcessor();
	}
	
	@Bean
	public BeanPostProcessor postProcessAfterInitialization(){
		return new MyBeanPostProcessor();
	} 
} 
 
