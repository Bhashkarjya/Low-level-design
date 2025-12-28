package behavioral.chainOfResponsibility.handlers;

import behavioral.chainOfResponsibility.request.Request;

public class ManagerApprovalHandler implements ApprovalHandler {
    private ApprovalHandler nextHandler;
    private static final double MANAGER_MAX_LIMIT = 50000;
    @Override
    public void handle(Request request) {
        if (request.getAmount() <= MANAGER_MAX_LIMIT) {
            System.out.println("Reimbursement amount is within " + MANAGER_MAX_LIMIT + " rupees. Approving it");
        }
        else {
            System.out.println("Forwarding the request to director");
            this.nextHandler.handle(request);
        }
    }

    @Override
    public ApprovalHandler setNextHandler(ApprovalHandler handler) {
        this.nextHandler = handler;
        return this.nextHandler;
    }
}
