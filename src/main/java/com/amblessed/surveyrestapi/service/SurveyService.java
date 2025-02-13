package com.amblessed.surveyrestapi.service;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Feb-25
 */

import com.amblessed.surveyrestapi.model.Question;
import com.amblessed.surveyrestapi.model.Survey;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question("Question1", "Most Popular Cloud Platform Today?", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        Question question2 = new Question("Question2", "Fastest Growing Cloud Platform?", Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
        Question question3 = new Question("Question3", "Most Popular DevOps Tool?", Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

        Survey survey = new Survey("Survey1", "My First Survey", "Description of the Survey", questions);
        surveys.add(survey);
    }

    public List<Survey> retrieveAllSurveys() {
        return surveys;
    }

    public Survey getSingleSurveyByID(String surveyId) {
        return surveys.stream().filter(survey -> survey.getId().equalsIgnoreCase(surveyId)).findFirst().orElse(null);

    }

    public List<Question> getAllQuestionsForSurveyByID(String surveyId) {

        Survey survey = getSingleSurveyByID(surveyId);
        if (survey == null) {
            return Collections.emptyList();
        }
        return survey.getQuestions();
    }

    public Question getQuestionForSurveyByID(String surveyId, String questionId) {
        List<Question> questions = getAllQuestionsForSurveyByID(surveyId);
        if (questions == null) {
            return null;
        }
        return questions.stream().filter(question -> question.getId().equalsIgnoreCase(questionId)).findFirst().orElse(null);
    }

    public String createNewSurveyQuestion(String surveyId, Question question) {
        List<Question> questions = getAllQuestionsForSurveyByID(surveyId);
        String randomId = generateRandomId();
        question.setId("Question" + randomId);
        questions.add(question);
        return question.getId();
    }

    private static String generateRandomId() {
        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(32, secureRandom).toString();
    }
}
