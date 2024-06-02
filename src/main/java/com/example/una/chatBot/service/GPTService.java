package com.example.una.chatBot.service;

import com.example.una.chatBot.dto.GPTResponse;
import com.example.una.chatBot.entity.GPTResponseEntity;
import com.example.una.chatBot.repository.GPTResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GPTService {

    @Autowired
    private GPTResponseRepository gptResponseRepository;

    @Transactional
    public void saveGPTResponseEntity(GPTResponse gptResponse) {
        GPTResponse.Choice choice = gptResponse.getChoices().get(0);
        GPTResponseEntity gptResponseEntity = new GPTResponseEntity();
        gptResponseEntity.setChoiceIndex(choice.getIndex());
        gptResponseEntity.setMessageContent(choice.getMessage().getContent());
        gptResponseRepository.save(gptResponseEntity);
    }
}
