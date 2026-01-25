package com.sist.web;

//import org.springframework.ai.google.genai.GoogleGenAiChatModel;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableScheduling
public class SpringBootLastProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLastProjectApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner runner(GoogleGenAiChatModel model) {
//		return args-> {
//			String response = model.call("오늘 서울 날씨");
//			System.out.println(response);
//		};
//	}
}
