package com.smartcity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartcity.model.Issue;
import com.smartcity.service.IssueService;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    @Autowired
    private IssueService issueService; // Autowire the IssueService
 
    
    @PostMapping
    public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) {
        Issue createdIssue = issueService.saveIssue(issue); // Call service to save the issue
        return ResponseEntity.ok(createdIssue);
    }

    @GetMapping
    public ResponseEntity<List<Issue>> getAllIssues() {
        List<Issue> issues = issueService.getAllIssues(); // Fetch all issues using service
        return ResponseEntity.ok(issues);
    }
   
}
