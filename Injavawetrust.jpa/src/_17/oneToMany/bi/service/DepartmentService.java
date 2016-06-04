package _17.oneToMany.bi.service;

import _17.oneToMany.bi.model.Department2;

public interface DepartmentService {

	public Department2 createDepartment(String name);

	public Department2 findDepartment(int id);
}
