package com.ai.springai.crash;


import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenAIController {

    private final ChatService chatService;

    private final ImageService imageService;
    private final RecipeService recipeService;


    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }


    @GetMapping("generate-image")
    public List<String> generateImages(@RequestParam String prompt)  {
        ImageResponse imageResponse = imageService.generateImage(prompt);
        List<String> list = imageResponse.getResults().stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
        return list;
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,
                                @RequestParam(defaultValue = "any") String cuisine,
                                @RequestParam(defaultValue = "") String dietaryRestriction) {
        return recipeService.createRecipe(ingredients, cuisine, dietaryRestriction);
    }
}
