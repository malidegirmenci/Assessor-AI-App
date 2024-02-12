package com.madtech.assessorai.dto;

import com.madtech.assessorai.utils.ValidationMsgPatterns;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@NoArgsConstructor
@Data
public class ReqCompletions {
    @NotNull(message = "Prompt " + ValidationMsgPatterns.notNull)
    @NotEmpty(message = "Prompt " + ValidationMsgPatterns.notEmpty)
    private String prompt;
}