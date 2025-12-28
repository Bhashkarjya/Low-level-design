package structural.proxy;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public void getEmployeeInfo(String employeeId) {
        System.out.println("Fetching employee info for id : " + employeeId);
    }

    @Override
    public void createEmployee(String name) {
        System.out.println("Creating a new employee with name : " + name);
    }
}
