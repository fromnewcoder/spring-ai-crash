package com.ai.springai.crash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.setProperty("java.net.useSystemProxies", "true");
		System.setProperty("http.proxyHost", "127.0.0.1");
		System.setProperty("http.proxyPort", "10809");
		System.setProperty("https.proxyHost", "127.0.0.1");
		System.setProperty("https.proxyPort", "10809");
		SpringApplication.run(Application.class, args);
	}

}
