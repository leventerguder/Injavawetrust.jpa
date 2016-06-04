package _08.mapping.temporal.service;

import java.util.Calendar;
import java.util.Date;

import _08.mapping.temporal.model.Employee8;

public interface EmployeeService {

	public Employee8 createEmployee(int id, String name, String surname, int salary,Date startDate, Calendar birthDate);

}
