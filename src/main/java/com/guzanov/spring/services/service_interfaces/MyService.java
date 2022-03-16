package com.guzanov.spring.services.service_interfaces;

import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;

import java.util.List;
import java.util.Map;

public interface MyService {
    List<Employee> getAllEmployees();

    void saveOrUpdateEmployee(Employee employee);

    boolean deleteEmployee(int emp_id);

    Employee getEmployeeByID(int emp_id);

    Detail getEmployeeDetailByID(int emp_id);

    Department getEmployeeDepartmentByID(int emp_id);

    //------
    void updateDetail(Detail detail);

    Detail getDetailByID(int detail_id);

    Employee getEmployeeByDetailID(int detail_id);

//    Detail getDetailByEmployeeID(int empId);

    //------
    void updateDepartment(Department department);

    Department getDepartmentByID(String dep_id);

    List<Employee> getAllEmployeeByDepartmentID(int dep_id);

    Map<String, String> getAllDepartments();

    List<Department> getAllDepartmentsList();
}
