package behavioral.chainOfResponsibility.handlers;

import behavioral.chainOfResponsibility.request.Request;

public class TeamLeadApprovalHandler implements ApprovalHandler {
    private ApprovalHandler nextHandler;
    private static final double TEAM_LEAD_MAX_LIMIT = 10000;
    @Override
    public void handle(Request request) {
        System.out.println("Request has been forwarded to Team Lead");
        if (request.getAmount() <= TEAM_LEAD_MAX_LIMIT) {
           System.out.println("Reimbursement amount is within " + TEAM_LEAD_MAX_LIMIT + " rupees. Approving it");
        }
        else {
            System.out.println("Forwarding the request to manager");
            this.nextHandler.handle(request);
        }
    }

    @Override
    public ApprovalHandler setNextHandler(ApprovalHandler handler) {
        this.nextHandler = handler;
        return this.nextHandler;
    }
}
