<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
    <h2>Update Employee detail:</h2>
    <br><br>
    <form:form action="saveDetail" modelAttribute="detail">
        <form:hidden path="id"/>

        <strong>Employee ID: </strong> ${detail.employee.id}
        <br>
        <strong>Detail ID: </strong> ${detail.id}
        <br><br>
        <strong>Email: </strong><form:input path="email"/><form:errors path="email"/>
        <br>
        <strong>Phone number: </strong><form:input path="phone_number"/><form:errors path="phone_number"/>
        <br>
        <strong>Country: </strong><form:input path="country"/><form:errors path="country"/>

        <br><br>
        <input type="submit" value="Save">
    </form:form>
    </body>
</html>