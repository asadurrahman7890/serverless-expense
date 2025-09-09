package com.expensetracker.model;

import java.time.LocalDateTime;

public class Expense {
    private String id;
    private String userId;
    private String description;
    private double amount;
    private String category;
    private LocalDateTime date;
    
    // Constructors
    public Expense() {}
    
    public Expense(String id, String userId, String description, 
                   double amount, String category, LocalDateTime date) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}