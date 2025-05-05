package com.ai.springai.crash;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.*;


@Service
@Slf4j
public class ChatService {
    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel){
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt){
       String property = System.getProperty("java.net.useSystemProxies");
        log.info("java.net.useSystemProxies:{}", property);
//        HttpURLConnection googleConnection = null;
//        Object content = null;
//        try {
//            URL url = new URL("http://www.google.com");
//            googleConnection = (HttpURLConnection) url.openConnection();
//            googleConnection.setConnectTimeout(3000);
//            googleConnection.connect();
//            content = googleConnection.getContent();
//            log.info("withOutProxy:{}", content);
//        } catch (IOException e) {
//            log.info("withOutProxy occur error");
//        }
//
//        try {
//            String proxyHost =  "127.0.0.1";
//            int proxyPort = 10809;
//
//            // Create a proxy object
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress( proxyHost, proxyPort));
//
//            URL url = new URL("http://www.google.com");
//            googleConnection = (HttpURLConnection) url.openConnection(proxy);
//            googleConnection.setConnectTimeout(3000);
//            googleConnection.connect();
//            content = googleConnection.getContent();
//            log.info("customProxy:{}", content);
//        } catch (IOException e) {
//            log.info("customProxy occur error");
//        }
//
//        return content.toString();
//
//        try {
//
//            googleConnection = new HttpURLConnection(new URL("http://www.google.com"), null);
//            googleConnection.setConnectTimeout(3000);
//            googleConnection.connect();
//            content = googleConnection.getContent();
//            log.info("systemProxy:{}", content);
//        } catch (IOException e) {
//            log.info("systemProxy occur error");
//        }


//        ChatResponse response = chatModel.call(
//               new Prompt(
//                       prompt,
//                       OpenAiChatOptions.builder()
//                               .model("gpt-4o-mini")
//                               .temperature(0.4)
//                               .build()
//               ));

       return chatModel.call(prompt);
    }

}
