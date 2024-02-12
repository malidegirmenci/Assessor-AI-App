package com.madtech.assessorai.controller;

import com.madtech.assessorai.dto.ReqQuestion;
import com.madtech.assessorai.dto.ResQuestion;
import com.madtech.assessorai.service.IServiceGptCompletions;
import com.madtech.assessorai.service.IServiceQuestion;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class QuestionController {
    private IServiceQuestion serviceQuestion;
    private IServiceGptCompletions serviceGptCompletions;

    @PostMapping("/question")
    public ResQuestion create(@Valid @RequestBody ReqQuestion reqQuestion) {
        return serviceQuestion.create(reqQuestion);
    }

    @GetMapping("/question/all")
    public List<ResQuestion> readAll() {
        return serviceQuestion.readAll();
    }

    @GetMapping("/question/{id}")
    public ResQuestion readById(@PathVariable long id) {
        return serviceQuestion.readById(id);
    }

    @PutMapping("/question/{id}")
    public ResQuestion update(@PathVariable long id, @Valid @RequestBody ReqQuestion reqQuestion) {
        return serviceQuestion.update(id, reqQuestion);
    }

    @DeleteMapping("question/{id}")
    public ResQuestion delete(@PathVariable long id) {
        return serviceQuestion.delete(id);
    }
}