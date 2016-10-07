package _13.idgeneration.identity.dao;

import _13.idgeneration.identity.model.Employee13;

public interface EmployeeDAO {

	public Employee13 createEmployee(String name, String surname, int salary);

}
