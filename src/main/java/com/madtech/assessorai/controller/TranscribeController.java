package com.madtech.assessorai.controller;

import com.madtech.assessorai.dto.ReqCompletions;
import com.madtech.assessorai.dto.ResCompletions;
import com.madtech.assessorai.entity.Question;
import com.madtech.assessorai.service.FileService;
import com.madtech.assessorai.service.IServiceGptCompletions;
import com.madtech.assessorai.service.IServiceQuestion;
import com.madtech.assessorai.service.TranscribeService;
import com.madtech.assessorai.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/whisper")
public class TranscribeController {
    private FileService fileService;
    private TranscribeService whisperTranscribe;

    private IServiceQuestion serviceQuestion;
    private IServiceGptCompletions serviceGptCompletions;

    @PostMapping(value = "/transcriptions", consumes = "multipart/form-data")
    public ResponseEntity<ResCompletions> transcriptions(@RequestParam("file") MultipartFile file) throws IOException {

        Question question = serviceQuestion.findQuestionById(9);
        String savedVideoPath = fileService.saveFile(file);
        System.out.println(file.getOriginalFilename()+" is saved in "+savedVideoPath);
        String convertedFileName = fileService.convertToMp3(file);
        System.out.println("File converted as "+convertedFileName);
        String dir = System.getProperty("user.dir")+ FileUtils.AUDIO_RESOURCES_PATH;
        String transcribedFile = whisperTranscribe.transcribe(dir + convertedFileName);
        fileService.deleteFile(savedVideoPath);
        fileService.deleteFile(dir+convertedFileName);

        ReqCompletions reqCompletions = new ReqCompletions();
        reqCompletions.setPrompt(transcribedFile);

        var response = serviceGptCompletions.evaluateUserAnswer(question, reqCompletions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
