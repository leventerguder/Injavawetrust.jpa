package _18.oneToMany.uni.service;

import _18.oneToMany.uni.model.Employee18;

public interface EmployeeService {

    public Employee18 createEmployee(String name, String surname, int salary);

    public Employee18 findEmployee(int id);

}
