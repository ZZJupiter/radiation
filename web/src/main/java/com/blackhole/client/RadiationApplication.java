package com.blackhole.client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * black hole 客户端
 * @author catface
 */
@SpringBootApplication
@MapperScan(value = {"com.blackhole.client.dao"})
public class RadiationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadiationApplication.class, args);
	}
}
