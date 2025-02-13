package com.amblessed.surveyrestapi.controller;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Feb-25
 */


import com.amblessed.surveyrestapi.service.SurveyService;
import com.amblessed.surveyrestapi.model.Question;
import com.amblessed.surveyrestapi.model.Survey;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class SurveyController {

    private SurveyService surveyService;

    @GetMapping("/surveys")
    public List<Survey> retrieveAllSurveys() {
        return surveyService.retrieveAllSurveys();
    }

    @GetMapping("/surveys/{surveyId}")
    public Survey getSingleSurveyByID(@PathVariable String surveyId) {
        Survey survey = surveyService.getSingleSurveyByID(surveyId);
        if (survey == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey Not Found");
        }
        return survey;
    }

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> getAllQuestionsForSurveyByID(@PathVariable String surveyId) {
        List<Question> questions = surveyService.getAllQuestionsForSurveyByID(surveyId);
        if (questions == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey Not Found");
        }
        return questions;
    }


    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionForSurveyByID(@PathVariable String surveyId, @PathVariable String questionId) {
        Question question = surveyService.getQuestionForSurveyByID(surveyId, questionId);
        if (question == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Survey Not Found");
        }
        return question;
    }

    @PostMapping("/surveys/{surveyId}/questions")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
       String questionId = surveyService.createNewSurveyQuestion(surveyId, question);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId).toUri();
       return ResponseEntity.created(location).build();
    }
}
