package com.expensetracker.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

import java.util.HashMap;
import java.util.Map;

public class ExpenseHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final ExpenseService expenseService;
    private final ObjectMapper objectMapper;
    
    public ExpenseHandler() {
        this.expenseService = new ExpenseService();
        this.objectMapper = new ObjectMapper();
    }
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        
        try {
            String httpMethod = input.getHttpMethod();
            String path = input.getPath();
            
            switch (httpMethod) {
                case "GET":
                    if (path.equals("/expenses")) {
                        return getAllExpenses(input);
                    } else if (path.startsWith("/expenses/")) {
                        return getExpenseById(input);
                    }
                    break;
                    
                case "POST":
                    if (path.equals("/expenses")) {
                        return createExpense(input);
                    }
                    break;
                    
                case "PUT":
                    if (path.startsWith("/expenses/")) {
                        return updateExpense(input);
                    }
                    break;
                    
                case "DELETE":
                    if (path.startsWith("/expenses/")) {
                        return deleteExpense(input);
                    }
                    break;
            }
            
            return createResponse(404, "Not Found");
            
        } catch (Exception e) {
            context.getLogger().log("Error: " + e.getMessage());
            return createResponse(500, "Internal Server Error");
        }
    }
    
    private APIGatewayProxyResponseEvent getAllExpenses(APIGatewayProxyRequestEvent input) {
        // Implementation for getting all expenses
        return createResponse(200, "Get all expenses - Coming soon!");
    }
    
    private APIGatewayProxyResponseEvent getExpenseById(APIGatewayProxyRequestEvent input) {
        // Implementation for getting expense by ID
        return createResponse(200, "Get expense by ID - Coming soon!");
    }
    
    private APIGatewayProxyResponseEvent createExpense(APIGatewayProxyRequestEvent input) {
        // Implementation for creating expense
        return createResponse(201, "Create expense - Coming soon!");
    }
    
    private APIGatewayProxyResponseEvent updateExpense(APIGatewayProxyRequestEvent input) {
        // Implementation for updating expense
        return createResponse(200, "Update expense - Coming soon!");
    }
    
    private APIGatewayProxyResponseEvent deleteExpense(APIGatewayProxyRequestEvent input) {
        // Implementation for deleting expense
        return createResponse(200, "Delete expense - Coming soon!");
    }
    
    private APIGatewayProxyResponseEvent createResponse(int statusCode, String body) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        response.setStatusCode(statusCode);
        response.setBody(body);
        
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "*");
        response.setHeaders(headers);
        
        return response;
    }
}