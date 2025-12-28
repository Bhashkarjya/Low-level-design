package structural.proxy;

public class Main {
    public static void main(String[] args) {
        EmployeeDao userProxyObj = new EmployeeDaoProxy("USER");
        userProxyObj.getEmployeeInfo("1"); //access granted
        userProxyObj.createEmployee("John"); //access denied
    }
}
