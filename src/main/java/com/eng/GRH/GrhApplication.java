package com.eng.GRH;

import com.eng.GRH.aspect.AspectClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AspectClass.class)
public class GrhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrhApplication.class, args);
	}

}
