package com.guzanov.spring.dao.dao_interfaces;

import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentDAO {
    Map<String, String> getAllDepartments();
    void updateDepartment(Department department);

    Department getDepartmentByID(String dep_id);

    List<Employee> getAllEmployeeByDepartmentID(int dep_id);

    List<Department> getAllDepartmentsList();
}
