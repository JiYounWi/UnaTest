package com.example.una.chatBot.controller;

import com.example.una.chatBot.dto.GPTRequest;
import com.example.una.chatBot.dto.GPTResponse;
import com.example.una.chatBot.service.GPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GPTController {

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    @Autowired
    private GPTService gptService;

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam("prompt") String prompt){

        GPTRequest request = new GPTRequest(
                model, prompt, 1, 256, 1, 2, 2);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GPTRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<GPTResponse> responseEntity = restTemplate.postForEntity(
                apiUrl, entity, GPTResponse.class);

        GPTResponse gptResponse = responseEntity.getBody();

        System.out.println("질문 : " + prompt);
        System.out.println("지피티 답변 : " + gptResponse.getChoices().get(0).getMessage().getContent());

        return ResponseEntity.ok(gptResponse.getChoices().get(0).getMessage().getContent());
    }
}
