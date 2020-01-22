package Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Composite_Pattern {
    public static void main(String[] args) {
        Developer dev = new Developer(100, "John");
        Manager manager = new Manager(101, "Whisky");
        CompanyDirectory company = new CompanyDirectory();
        company.addEmployee(dev);
        company.addEmployee(manager);
        company.showEmployeeDetails();
    }
}
interface Employee{
    public void showEmployeeDetails();
}
class Developer implements Employee{
    private String name;
    private long empId;

    public Developer(long empId, String name){
        this.name = name;
        this.empId = empId;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Name: "+name+", ID: "+empId);
    }
}
class Manager implements Employee{
    private String name;
    private long empId;
    public Manager(long empId, String name){
        this.empId = empId;
        this.name = name;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Name: "+name+", ID: "+empId);
    }
}
class CompanyDirectory implements Employee{
    private List<Employee> employeeList = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails() {
        for (Employee employee: employeeList){
            employee.showEmployeeDetails();
        }
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
    }
}