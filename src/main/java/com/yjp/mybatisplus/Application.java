package com.yjp.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.yjp.mybatisplusmapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
        System.out.println("嘻嘻");
	}

}
