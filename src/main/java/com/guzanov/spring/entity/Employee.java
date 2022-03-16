package com.guzanov.spring.entity;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Size(min = 2, max = 15, message = "--> The length should be between 2 and 15")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "--> The length should be between 2 and 15")
    @Column(name = "surname")
    private String surname;
//    @Size(min = 300, message = "--> The salary should be more than $ 300")
    @Column(name = "salary")
    private int salary;

    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private  Department department;
    @Transient
    private String department_select;
    @Transient
    private static Map<String, String> allDepartments;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "detail_id")
    private Detail detail_id;




    public Employee() {
        allDepartments = new HashMap<>();
    }

    public Employee(String name, String surname, int salary, Department department, Detail detail_id) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.detail_id = detail_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(department, employee.department) && Objects.equals(department_select, employee.department_select) && Objects.equals(detail_id, employee.detail_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, salary, department, department_select, detail_id);
    }

    public Map<String, String> getAllDepartments() {
        return allDepartments;
    }

    public void setAllDepartments(Map<String, String> allDepartments) {
        this.allDepartments = allDepartments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department dep_id) {
        this.department = dep_id;
    }

    public Detail getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Detail detail_id) {
        this.detail_id = detail_id;
    }

    public String getDepartment_select() {
        return department_select;
    }

    public void setDepartment_select(String department_select) {
        this.department_select = department_select;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", dep_id=" + department +
                ", detail_id=" + detail_id +
                '}';
    }
}
