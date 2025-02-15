package com.amblessed.surveyrestapi;

import java.util.List;

import com.amblessed.surveyrestapi.model.UserDetails;
import com.amblessed.surveyrestapi.repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SurveyRestApiApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserDetailsRepository userDetailsRepository;

    public SurveyRestApiApplication(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SurveyRestApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
        userDetailsRepository.save(new UserDetails("Henry", "Admin"));
        userDetailsRepository.save(new UserDetails("Samuel", "Admin"));
        userDetailsRepository.save(new UserDetails("Mark", "User"));

        // List<UserDetails> userDetails = userDetailsRepository.findAll()
        List<UserDetails> userDetails = userDetailsRepository.findByRole("Admin");
        userDetails.forEach(user -> logger.info("User: {}", user));



    }
}
