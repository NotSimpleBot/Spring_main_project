package com.guzanov.spring.services;

import com.guzanov.spring.dao.dao_interfaces.DepartmentDAO;
import com.guzanov.spring.dao.dao_interfaces.DetailDAO;
import com.guzanov.spring.dao.dao_interfaces.EmployeeDAO;
import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;
import com.guzanov.spring.services.service_interfaces.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MyService_Impl implements MyService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private DetailDAO detailDAO;
    @Autowired
    private DepartmentDAO departmentDAO;


    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee employee) {
        employeeDAO.saveOrUpdateEmployee(employee);
    }

    @Override
    @Transactional
    public boolean deleteEmployee(int emp_id) {
        return employeeDAO.deleteEmployee(emp_id);
    }

    @Override
    @Transactional
    public Employee getEmployeeByID(int emp_id) {
        return employeeDAO.getEmployeeByID(emp_id);
    }

    @Override
    @Transactional
    public Detail getEmployeeDetailByID(int emp_id) {
        return employeeDAO.getEmployeeDetailByID(emp_id);
    }

    @Override
    @Transactional
    public Department getEmployeeDepartmentByID(int emp_id) {
        return employeeDAO.getEmployeeDepartmentByID(emp_id);
    }

    @Override
    @Transactional
    public void updateDetail(Detail detail) {
        detailDAO.updateDetail(detail);
    }

    @Override
    @Transactional
    public Detail getDetailByID(int detail_id) {
        return detailDAO.getDetailByID(detail_id);
    }

    @Override
    @Transactional
    public Employee getEmployeeByDetailID(int detail_id) {
        return detailDAO.getEmployeeByDetailID(detail_id);
    }

//    @Override
//    @Transactional
//    public Detail getDetailByEmployeeID(int empId) {
//        return detailDAO.getDetailByEmployeeID(empId);
//    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional
    public Department getDepartmentByID(String dep_id) {
        return departmentDAO.getDepartmentByID(dep_id);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployeeByDepartmentID(int dep_id) {
        return departmentDAO.getAllEmployeeByDepartmentID(dep_id);
    }

    @Override
    @Transactional
    public Map<String, String> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    @Transactional
    public List<Department> getAllDepartmentsList() {
        return departmentDAO.getAllDepartmentsList();
    }
}
