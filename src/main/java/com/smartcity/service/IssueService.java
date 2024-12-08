package com.smartcity.service;

import com.smartcity.model.Issue;
import com.smartcity.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired
    private IssueRepository issueRepository;
    
    // Add a new issue
    public Issue saveIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    // Get all issues
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // Update issue status
    public Issue updateIssueStatus(Long id, String status) {
        Issue existingIssue = issueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
        existingIssue.setStatus(status);
        return issueRepository.save(existingIssue);
    }
}
