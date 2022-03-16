package com.guzanov.spring.controllers;

import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;
import com.guzanov.spring.services.service_interfaces.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class Controller_mvc {
    @Autowired
    private MyService service;
    private Map<String, String> allDepartmentsMap;

    @RequestMapping("/")
    public String getAllEmployees(Model model) {
        List<Employee> allEmployees = service.getAllEmployees();
        if (Objects.isNull(allDepartmentsMap)) {
            allDepartmentsMap = service.getAllDepartments();
        }
        model.addAttribute("allEmployees", allEmployees);
        return "all-emps";
    }

    //===============
    @RequestMapping("/createNewEmployee")
    public String createNewEmployee(Model model) {
        Employee newEmployee = new Employee();
        newEmployee.setAllDepartments(allDepartmentsMap);

        model.addAttribute("employee", newEmployee); //имя должно быть одинаковое в этом методе и в updateEmployeeInfo
        return "create_update-emp";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployeeInfo(@RequestParam("empId") int empId, Model model) {
        Employee updateEmployee = service.getEmployeeByID(empId);
        updateEmployee.setAllDepartments(allDepartmentsMap);

        model.addAttribute("employee", updateEmployee);
        return "create_update-emp";
    }

    //===============
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        Detail detailFromDB;
        if (Objects.isNull(detailFromDB = service.getEmployeeDetailByID(employee.getId()))) {
            detailFromDB = new Detail();
        }
        detailFromDB.setEmail(employee.getDetail_id().getEmail());
        detailFromDB.setPhone_number(employee.getDetail_id().getPhone_number());
        detailFromDB.setCountry(employee.getDetail_id().getCountry());
        detailFromDB.setEmployee(employee); //вот в этом была ошибка, КЕК
        employee.setDetail_id(detailFromDB);

        Department departmentFromDB = service.getDepartmentByID(employee.getDepartment_select());
        employee.setDepartment(departmentFromDB);
        if (bindingResult.hasErrors()) {
            employee.setAllDepartments(allDepartmentsMap);
//            model.addAttribute("employee", employee);
            return "create_update-emp";
        } else {
            System.out.println("4");
            service.saveOrUpdateEmployee(employee);
            return "redirect:/";
        }
    }

    //Detail------------------------------------------------------------------------------------------------------------
    @RequestMapping("/getDetail")
    public String getEmployeeDetail(@RequestParam("detailId") int detailId, Model model) {
        Detail detail = service.getDetailByID(detailId);
        model.addAttribute("detail", detail);
        return "get-detail";
    }

    @RequestMapping("/updateDetail")
    public String updateDetail(@RequestParam("detailId") int detailId, Model model) {
        Detail detail = service.getDetailByID(detailId);
        model.addAttribute("detail", detail);
        return "update-detail";
    }

    @RequestMapping("/saveDetail")
    public String saveDetail(@Valid @ModelAttribute("detail") Detail detail, BindingResult bindingResult) {
        Employee employee = service.getEmployeeByDetailID(detail.getId());
        if (bindingResult.hasErrors()) {
            detail.setEmployee(employee);
            return "update-detail";
        } else {
            employee.setDetail_id(detail);
            service.saveOrUpdateEmployee(employee);
            return "redirect:/";
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    //dep------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/getDepartment")
    public String getEmployeeDepartment(@RequestParam("depId") String depId, Model model) {
        Department department = service.getDepartmentByID(depId);
        model.addAttribute("department", department);
        return "get-department";
    }
//    @RequestMapping("/updateDepartment")
//    public String updateDepartment(@RequestParam("depId") String depId, Model model){
//        Department department =service.getDepartmentByID(depId);
//        model.addAttribute("department", department);
//        return "update-department";
//    }
//    @RequestMapping("/saveDepartment")
//    public String saveDepartment(@ModelAttribute("department") Department department){
//
//        return "redirect:/";
//    }
    //dep------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int empId) {
        service.deleteEmployee(empId);
        return "redirect:/";
    }

    @RequestMapping("/redirectToStartPage")
    public String redirectToStartPageM() {
        return "redirect:/";
    }
}
