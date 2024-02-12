package com.madtech.assessorai.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ReqCGPTCompletions {

    private String model;
    private List<Message> messages;

    public ReqCGPTCompletions(String model, List<Message> messages) {
        this.model = model;
        this.messages = messages;
    }
}
