package src.main.java.designPatterns.chainOfResponsibility.middlewares;

import src.main.java.designPatterns.chainOfResponsibility.RequestHandler;

public class Authentication extends Middleware {
    private RequestHandler nextHandler;

    public Authentication(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean checkAuthentication(String request) {
        //Just return true for namesake. We are not learning how to authenticate an API request, we are learning design 
        // patterns here xD.
        return true;
    }

    @Override
    public void handleRequest(String request) {
        boolean isAuthenticated = checkAuthentication(request);
        if(!isAuthenticated) {
            System.out.println("API request not authenticated. 401 Error.");
            Thread.currentThread().stop();
        }
        System.out.println("Request authenticated successfully");
        this.nextHandler.handleRequest(request);
    }
}
