package src.main.java.designPatterns.chainOfResponsibility.middlewares;

import src.main.java.designPatterns.chainOfResponsibility.RequestHandler;

public class Throttler extends Middleware{
    private RequestHandler nextHandler;
    private int requestPerMinute;
    private static int allowedRequestsPerMinute = 5;

    public Throttler(int requestPerMinute, RequestHandler nextHandler) {
        this.requestPerMinute = requestPerMinute;
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String request) {
        if(requestPerMinute > allowedRequestsPerMinute) {
            System.out.println("API request has been throttled. Please retry later.");
            Thread.currentThread().stop();
        }
        System.out.println("API request is withing the rate limits");
        this.nextHandler.handleRequest(request);
    }
}
