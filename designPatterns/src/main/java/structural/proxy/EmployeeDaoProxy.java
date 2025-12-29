package structural.proxy;

public class EmployeeDaoProxy implements EmployeeDao{
    private final EmployeeDaoImpl employeeDao;
    private final String clientRole;
    public EmployeeDaoProxy(String clientRole) {
        this.clientRole = clientRole;
        this.employeeDao = new EmployeeDaoImpl();
    }
    @Override
    public void getEmployeeInfo(String employeeId) {
        if(this.clientRole == "USER" || this.clientRole == "ADMIN") {
            this.employeeDao.getEmployeeInfo(employeeId);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }

    @Override
    public void createEmployee(String name) {
        if(this.clientRole == "ADMIN") {
            this.employeeDao.createEmployee(name);
        } else {
            throw new RuntimeException("Access Denied");
        }
    }
}
