package com.madtech.assessorai.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Choice {
    private int index;
    private Message message;
}
