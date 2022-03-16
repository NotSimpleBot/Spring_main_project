package com.guzanov.spring.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Pattern(regexp = ".*@gmail.com", message = "<--@gmail.com")
    @Column(name = "email")
    private String email;
    @Pattern(regexp = "\\d{3}-\\d{2}-\\d{2}", message = "<-- XXX-XX-XX")
    @Column(name = "phone_number")
    private String phone_number;
    @NotBlank(message = "NotEmpty, NotBlank, NotNull!")
    @Column(name = "country")
    private String country;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "detail_id", fetch = FetchType.EAGER)
    private Employee employee;

    public Detail() {
    }

    public Detail(String email, String phone_number, String country) {
        this.email = email;
        this.phone_number = phone_number;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
