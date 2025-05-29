import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.main.java.designPatterns.chainOfResponsibility.RequestHandler;
import src.main.java.designPatterns.chainOfResponsibility.middlewares.Authentication;
import src.main.java.designPatterns.chainOfResponsibility.middlewares.Authorization;
import src.main.java.designPatterns.chainOfResponsibility.middlewares.Throttler;

public class ChainOfResponsibilityClient {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        public static void main(String[] args) throws IOException{
        String request = "API dummy request";
        System.out.println("Enter the number of API requests per second (RPS)");
        int rateLimit = Integer.parseInt(reader.readLine());

        RequestHandler requestHandler = new Authentication(new Throttler(rateLimit, new Authorization(null)));
        requestHandler.handleRequest(request);
    }
}