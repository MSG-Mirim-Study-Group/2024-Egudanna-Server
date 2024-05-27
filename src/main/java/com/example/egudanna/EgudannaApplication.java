package com.example.egudanna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
// 에러 해결!!
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class EgudannaApplication {
//	@Autowired
//	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(EgudannaApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		senderService.sendMail("s2216@e-mirim.hs.kr", // 받는 사람의 이메일
//				"지현아 안녕",
//				"This is Body of Email");
//	}
}