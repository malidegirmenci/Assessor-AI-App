package com.madtech.assessorai.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseFormat {
    private String type;

    public ResponseFormat(eResponseFormat responseFormat) {
        this.type = responseFormat.getValue();
    }
}