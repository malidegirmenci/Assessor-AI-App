package com.madtech.assessorai.service;

import com.madtech.assessorai.dto.ReqQuestion;
import com.madtech.assessorai.dto.ResQuestion;
import com.madtech.assessorai.entity.Question;

public interface IServiceQuestion extends
        IServiceCreate<ResQuestion, ReqQuestion>,
        IServiceRead<ResQuestion>,
        IServiceUpdate<ResQuestion, ReqQuestion>,
        IServiceDelete<ResQuestion> {

    Question findQuestionById(long id);
}
