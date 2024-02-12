package com.madtech.assessorai.service;

import com.madtech.assessorai.dto.ReqCompletions;
import com.madtech.assessorai.dto.ResCompletions;
import com.madtech.assessorai.entity.Question;

public interface IServiceGptCompletions {
    ResCompletions evaluateUserAnswer(Question question, ReqCompletions reqCompletions);
}
