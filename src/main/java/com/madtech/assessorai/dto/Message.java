package com.madtech.assessorai.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Message {

    private eRole role;
    private String content;
}