package com.example.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlApplication {

    
	
	public static void main() {
		System.out.print("Hi");;
	}
	
	public static void main(String[] args) {
		main(); 
        SpringApplication.run(MysqlApplication.class, args);
        
    }

}
