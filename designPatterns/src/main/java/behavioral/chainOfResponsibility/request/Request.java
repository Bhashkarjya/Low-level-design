package behavioral.chainOfResponsibility.request;

public class Request {
    private RequestType requestType;
    private final double amount;
    private final String employeeId;

    public Request(RequestType type, double amount, String employeeId) {
        this.requestType = type;
        this.amount = amount;
        this.employeeId = employeeId;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

}
