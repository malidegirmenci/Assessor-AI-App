package com.madtech.assessorai.exception;

import java.time.LocalDateTime;

public record RespExceptionOpenAi(String message, LocalDateTime localDateTime) {
}
