package behavioral.chainOfResponsibility.handlers;

import behavioral.chainOfResponsibility.request.Request;

public class DirectorApprovalHandler implements ApprovalHandler {
    private ApprovalHandler nextHandler;
    private static final double DIRECTOR_MAX_LIMIT = 200000;
    @Override
    public void handle(Request request) {
        if (request.getAmount() <= DIRECTOR_MAX_LIMIT) {
            System.out.println("Reimbursement amount is within " + DIRECTOR_MAX_LIMIT + " rupees. Approving it");
        }
        else {
            System.out.println("Forwarding the request to Finance Team");
            this.nextHandler.handle(request);
        }
    }

    @Override
    public ApprovalHandler setNextHandler(ApprovalHandler handler) {
        this.nextHandler = handler;
        return this.nextHandler;
    }
}
