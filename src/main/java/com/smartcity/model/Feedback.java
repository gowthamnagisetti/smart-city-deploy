package com.smartcity.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    private String feedbackText;

    @Column(nullable = false)
    private int rating; // e.g., 1 to 5 stars
    
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
