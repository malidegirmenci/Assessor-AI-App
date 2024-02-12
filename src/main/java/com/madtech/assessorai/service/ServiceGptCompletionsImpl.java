package com.madtech.assessorai.service;

import com.madtech.assessorai.dto.*;
import com.madtech.assessorai.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceGptCompletionsImpl implements IServiceGptCompletions{

    @Value("${openai.api.v1.completions.model}")
    private String model;
    @Value("${openai.api.v1.completions.url}")
    private String urlOpenAiV1CompletionsUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResCompletions evaluateUserAnswer(Question question, ReqCompletions reqCompletions) {

        //prepare system message
        Message messageSystem = new Message();
        messageSystem.setRole(eRole.system);
        messageSystem.setContent("First work out your own solution to the problem. " +
                "Then compare your solution to the student's solution and evaluate if the student's solution" +
                " is correct or not give the result as Result: . " +
                "Don't decide if the student's solution is correct until you have done the problem yourself.");

        //prepare user message

        String responseMsg = "Problem Statement: " +
                question.getText() +
                "Student Solution: " +
                reqCompletions.getPrompt();

        Message messageUser = new Message();
        messageUser.setRole(eRole.user);
        messageUser.setContent(responseMsg);

        List<Message> messageList = new ArrayList<>();
        messageList.add(messageSystem);
        messageList.add(messageUser);

        ReqCGPTCompletions requestChatGPT = new ReqCGPTCompletions(model, messageList);

        ResCGPTCompletions responseChatGPT = restTemplate.postForObject(urlOpenAiV1CompletionsUrl, requestChatGPT, ResCGPTCompletions.class);

        ResCompletions resCompletions = new ResCompletions();
        assert responseChatGPT != null;
        resCompletions.setContent(responseChatGPT.getChoices().get(0).getMessage().getContent());

        return resCompletions;
    }
}