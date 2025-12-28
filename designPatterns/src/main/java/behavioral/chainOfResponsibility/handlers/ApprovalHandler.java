package behavioral.chainOfResponsibility.handlers;

import behavioral.chainOfResponsibility.request.Request;
public interface ApprovalHandler {
    public void handle(Request request);
    public ApprovalHandler setNextHandler(ApprovalHandler handler);
}
