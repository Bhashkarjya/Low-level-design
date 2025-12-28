package behavioral.chainOfResponsibility.handlers;

import behavioral.chainOfResponsibility.request.Request;

public class FinanceApprovalHandler implements ApprovalHandler{
    private ApprovalHandler nextHandler;
    private static final double FINANCE_TEAM_MAX_LIMIT = 500000;
    @Override
    public void handle(Request request) {
        if (request.getAmount() <= FINANCE_TEAM_MAX_LIMIT) {
            System.out.println("Reimbursement amount is within " + FINANCE_TEAM_MAX_LIMIT + " rupees. Approving it");
        }
        else {
            System.out.println("Rejecting the request");
        }
    }

    @Override
    public ApprovalHandler setNextHandler(ApprovalHandler handler) {
        this.nextHandler = handler;
        return this.nextHandler;
    }
}
