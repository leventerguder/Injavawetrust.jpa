package _08.mapping.temporal.dao;

import java.util.Calendar;
import java.util.Date;

import _08.mapping.temporal.model.Employee8;

public interface EmployeeDAO {

	public Employee8 insertEmployee(int id, String name, String surname, int salary,Date startDate, Calendar birthDate);

}
