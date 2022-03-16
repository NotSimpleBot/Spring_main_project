package com.guzanov.spring.dao.dao_interfaces;

import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    boolean deleteEmployee(int emp_id);

    Employee getEmployeeByID(int emp_id);

    Detail getEmployeeDetailByID(int emp_id);

    Department getEmployeeDepartmentByID(int emp_id);

}
