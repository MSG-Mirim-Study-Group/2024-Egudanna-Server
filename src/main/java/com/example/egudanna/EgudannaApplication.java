package com.example.egudanna;

import com.example.egudanna.email.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
// 에러 해결!!
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class EgudannaApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(EgudannaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		senderService.sendMail("okhagrace0610@gmail.com",
				"This is Subject",
				"This is Body of Email");
	}
}
