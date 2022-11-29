package com.demo;

import com.presentation.BookPresentation;
import java.util.Scanner;

import javax.persistence.Entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.persistence")
public class BookLayeredSpringbootDatajpaProjectApplication {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(BookLayeredSpringbootDatajpaProjectApplication.class, args);
		Scanner scanner=new Scanner(System.in);

		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("presentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}

	
	}

}
