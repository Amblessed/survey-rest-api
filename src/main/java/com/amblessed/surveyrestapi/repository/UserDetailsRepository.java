package com.amblessed.surveyrestapi.repository;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 15-Feb-25
 */


import com.amblessed.surveyrestapi.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    List<UserDetails> findByRole(String role);
}
