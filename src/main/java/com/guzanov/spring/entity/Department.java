package com.guzanov.spring.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployeeToDepartment(Employee employee){
        if (employeeList == null){
            employeeList = new ArrayList<>();
        }
        if (!employeeList.isEmpty()){
            for(Employee e : employeeList){
                if (employee.equals(e)){
                    System.out.println("Сотрудник уже добавлен в этот отдел!");
                    return;
                }
            }
        }
        employeeList.add(employee);
        employee.setDepartment(this);
    }

    public void deleteEmployeeFromDepartment(Employee employee){
        if (Objects.nonNull(employeeList) && !employeeList.isEmpty()){
            employeeList.removeIf(e -> e.equals(employee));
        }
    }
}
