package com.jdbc.connt;
import java.util.*;

public interface EmployeeRepository {
	void create(Employee employee);

	Employee read(int id);

	void update(Employee employee);

	void delete(int id);
	
	List<Employee> readAll();

}
