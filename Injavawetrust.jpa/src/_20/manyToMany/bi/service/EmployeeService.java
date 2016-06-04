package _20.manyToMany.bi.service;

import _20.manyToMany.bi.model.Employee20;

public interface EmployeeService {

    public Employee20 createEmployee(String name, String surname, int salary);

    public Employee20 findEmployee(int id);

}
