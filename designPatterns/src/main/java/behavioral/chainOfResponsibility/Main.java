package behavioral.chainOfResponsibility;

import behavioral.chainOfResponsibility.handlers.ApprovalHandler;
import behavioral.chainOfResponsibility.handlers.DirectorApprovalHandler;
import behavioral.chainOfResponsibility.handlers.FinanceApprovalHandler;
import behavioral.chainOfResponsibility.handlers.ManagerApprovalHandler;
import behavioral.chainOfResponsibility.handlers.TeamLeadApprovalHandler;
import behavioral.chainOfResponsibility.request.Request;
import behavioral.chainOfResponsibility.request.RequestType;

public class Main {
    public static void main(String[] args) {
        //Create the chain of handlers
        ApprovalHandler teamLead = new TeamLeadApprovalHandler();
        ApprovalHandler manager = new ManagerApprovalHandler();
        ApprovalHandler director = new DirectorApprovalHandler();
        ApprovalHandler finance = new FinanceApprovalHandler();
        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);
        director.setNextHandler(finance);

        //Create 4 requests
        Request r1 = new Request(RequestType.EXPENSE, 40000, "1");
        Request r2 = new Request(RequestType.PURCHASE, 205000, "2");
        Request r3 = new Request(RequestType.LEAVE, 7000, "3");
        Request r4 = new Request(RequestType.PURCHASE, 100000, "4");
        Request r5 = new Request(RequestType.EXPENSE, 1000000, "5");

        System.out.println("Handle Request 1");
        teamLead.handle(r1);
        System.out.println("Handle Request 2");
        teamLead.handle(r2);
        System.out.println("Handle Request 3");
        teamLead.handle(r3);
        System.out.println("Handle Request 4");
        teamLead.handle(r4);
        System.out.println("Handle Request 5");
        teamLead.handle(r5);

    }
}
