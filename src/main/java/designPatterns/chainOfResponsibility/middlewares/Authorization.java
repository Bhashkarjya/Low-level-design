package src.main.java.designPatterns.chainOfResponsibility.middlewares;

import src.main.java.designPatterns.chainOfResponsibility.RequestHandler;

public class Authorization extends Middleware{
    private RequestHandler nextHandler;

    public Authorization (RequestHandler nextHandler) {
        this.next = nextHandler;
    }

    boolean checkAuthorization(String request) {
        return true;
    }

    @Override
    public void handleRequest(String request) {
        boolean isAuthorized = checkAuthorization(request);

        if(!isAuthorized) {
            System.out.println("User not authorized");
            Thread.currentThread().stop();
        }

        System.out.println("User authorized");
    }
}
