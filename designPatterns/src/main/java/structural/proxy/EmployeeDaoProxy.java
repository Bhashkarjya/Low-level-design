package structural.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    private EmployeeDaoImpl employeeDao;
    private String clientRole;
    public EmployeeDaoProxy(String clientRole) {
        this.clientRole = clientRole;
        this.employeeDao = new EmployeeDaoImpl();
    }
    @Override
    public void getEmployeeInfo(String employeeId) {
        if(this.clientRole == "USER" || this.clientRole == "ADMIN") {
            employeeDao.getEmployeeInfo(employeeId);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee(String name) {
        if(this.clientRole == "ADMIN") {
            employeeDao.createEmployee(name);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}
