/**
 * 
 */
package com.boot.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * @author sunil.yadav
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com.boot.test.*")
@EnableAutoConfiguration
public class BootApplication {
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
		LambdaTest.lambda();// lambda java 8 example here.
		SumTwoNumbers numbers = (a, b) -> (a+b);
		System.out.println(numbers.sum(1,  13));
		print(numbers.sum(10, 15));
	}
	
	private static void print(int item) {
		System.out.println("sum is = " + item);
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/message");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}
}
