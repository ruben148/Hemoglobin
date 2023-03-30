package com.rbbr.hemoglobin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.logging.Logger;

import static java.lang.String.format;

@SpringBootApplication
public class HemoglobinApplication {

	public static void main(String[] args) {
		SpringApplication.run(HemoglobinApplication.class, args);
		//application.setWebApplicationType(WebApplicationType.NONE);
		//application.run(args);
	}
}

