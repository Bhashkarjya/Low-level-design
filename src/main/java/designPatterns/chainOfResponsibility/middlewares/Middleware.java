package src.main.java.designPatterns.chainOfResponsibility.middlewares;

import src.main.java.designPatterns.chainOfResponsibility.RequestHandler;

public abstract class Middleware implements RequestHandler{
    RequestHandler next;

    @Override
    public abstract void handleRequest(String request);
}
