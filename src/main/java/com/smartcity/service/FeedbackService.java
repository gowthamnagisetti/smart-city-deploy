package com.smartcity.service;

import com.smartcity.model.Feedback;
import com.smartcity.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    // Add new feedback
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // Get all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
