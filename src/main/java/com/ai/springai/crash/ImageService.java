package com.ai.springai.crash;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.image.*;
import org.springframework.ai.model.ModelOptionsUtils;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.zhipuai.ZhiPuAiImageModel;
import org.springframework.ai.zhipuai.ZhiPuAiImageOptions;
import org.springframework.ai.zhipuai.api.ZhiPuAiImageApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {

    private final ZhiPuAiImageModel zhiPuAiImageModel;

    public ImageResponse generateImage(String prompt){
        ImageResponse response = zhiPuAiImageModel.call(
                new ImagePrompt(prompt,
                        ImageOptionsBuilder.builder()
                                .N(3)
                                .height(768)
                                .width(1344).build())

        );
        return response;
    }
}
