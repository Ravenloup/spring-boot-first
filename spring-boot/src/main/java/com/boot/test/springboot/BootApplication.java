/**
 * 
 */
package com.boot.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
	}
}
