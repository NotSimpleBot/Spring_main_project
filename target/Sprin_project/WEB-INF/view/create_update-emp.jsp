<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
    <h2>Create/Update employee/INFO:</h2>
    <br><br>
    <form:form action="saveEmployee" modelAttribute="employee">
        <form:hidden path="id"/>
        <form:hidden path="department.id"/>
        <form:hidden path="department.name"/>
        <form:hidden path="detail_id.id"/>
        <strong>Name: </strong><form:input path="name"/><form:errors path="name"/> <br>
        <strong>Surname: </strong><form:input path="surname"/><form:errors path="surname"/><br>
        <strong>Salary: </strong><form:input path="salary"/><form:errors path="salary"/><br>
        <strong>Department_id: </strong>
        <form:radiobuttons path="department_select" items="${employee.allDepartments}"/>
        <br>
        <strong>Email: </strong><form:input path="detail_id.email"/><form:errors path="detail_id.email"/><br>
        <strong>Phone_number: </strong><form:input path="detail_id.phone_number"/><form:errors path="detail_id.phone_number"/><br>
        <strong>Country: </strong><form:input path="detail_id.country"/><form:errors path="detail_id.country"/><br>

        <input type="submit" value="OK">
    </form:form>
    </body>
</html>