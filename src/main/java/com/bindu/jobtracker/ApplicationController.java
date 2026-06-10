package com.bindu.jobtracker;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private List<JobApplication> applications = new ArrayList<>();

    public ApplicationController() {

        applications.add(
            new JobApplication(
                1L,
                "Google",
                "Software Engineer",
                "Applied"
            )
        );

        applications.add(
            new JobApplication(
                2L,
                "Amazon",
                "Backend Engineer",
                "Interview"
            )
        );
    }

    @GetMapping
    public List<JobApplication> getApplications() {
        return applications;
    }

    @PostMapping
    public JobApplication addApplication(
            @RequestBody JobApplication application) {

        application.setId(
                (long) (applications.size() + 1));

        applications.add(application);

        return application;
    }
}