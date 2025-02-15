package com.amblessed.surveyrestapi.model;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 15-Feb-25
 */


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String role;

    public UserDetails(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
