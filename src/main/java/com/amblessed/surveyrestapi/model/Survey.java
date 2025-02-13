package com.amblessed.surveyrestapi.model;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 13-Feb-25
 */


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Survey {

    private String id;
    private String title;
    private String description;
    private List<Question> questions;


}
