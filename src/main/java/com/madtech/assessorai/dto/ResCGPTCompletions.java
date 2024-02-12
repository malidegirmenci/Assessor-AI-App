package com.madtech.assessorai.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ResCGPTCompletions {
    private List<Choice> choices;
}