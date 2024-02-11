package com.madtech.assessorai.dto;

import com.madtech.assessorai.utils.ValidationMsgPatterns;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Data
public class ReqQuestion {
    @NotNull(message = "Text " + ValidationMsgPatterns.notNull)
    @NotEmpty(message = "Text " + ValidationMsgPatterns.notEmpty)
    @Length(min = 10, message = "Text " + ValidationMsgPatterns.minLenStr + " 10")
    @Length(max = 100, message = "Text " + ValidationMsgPatterns.maxLenStr + " 100")
    private String text;
}
