package com.amblessed.surveyrestapi.model;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Feb-25
 */


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Question {

    @Setter
    private String id;
    private String description;
    private List<String> options;
    private String correctAnswer;


}
