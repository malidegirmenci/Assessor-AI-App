package com.madtech.assessorai.dto;

import com.madtech.assessorai.validation.ValidationMessage;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@Data
public class ReqQuestion {
    @NotNull(message = "Text " + ValidationMessage.notNull)
    @NotEmpty(message = "Text " + ValidationMessage.notEmpty)
    @Length(min = 10, message = "Text " + ValidationMessage.minLenStr + " 10")
    @Length(max = 100, message = "Text " + ValidationMessage.maxLenStr + " 100")
    private String text;
}
