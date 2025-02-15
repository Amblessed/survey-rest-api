package com.amblessed.surveyrestapi.repository;



/*
 * @Project Name: survey-rest-api
 * @Author: Okechukwu Bright Onwumere
 * @Created: 15-Feb-25
 */


import com.amblessed.surveyrestapi.model.UserDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


// @RepositoryRestResource(collectionResourceRel = "userDetails", path = "user-details")
public interface UserDetailsRestRepository extends PagingAndSortingRepository<UserDetails, Long> {

    List<UserDetails> findByRole(String role);
}
