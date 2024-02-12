package com.madtech.assessorai.dto;

import com.madtech.assessorai.validation.ValidationMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@NoArgsConstructor
@Data
public class ReqCompletions {
    @NotNull(message = "Prompt " + ValidationMessage.notNull)
    @NotEmpty(message = "Prompt " + ValidationMessage.notEmpty)
    private String prompt;
}