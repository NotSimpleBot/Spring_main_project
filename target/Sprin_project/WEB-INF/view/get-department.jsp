<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
    <h2>Employee department:</h2>
    <br><br>
    <form:form action="redirectToStartPage" modelAttribute="department">
        <strong>Department ID: </strong>${department.id}
        <br>
        <strong>Department Name: </strong>${department.name}
        <br><br>
        <strong>Employees from this department:</strong>
        <br>
        <c:forEach var="emp" items="${department.employeeList}">
            {<strong>Surname: </strong>${emp.surname} | <strong>Salary: </strong>${emp.salary}}
            <br>
        </c:forEach>
        <br>
<%--        зачем обновлять департамент ? пока что не надо --%>
<%--        <c:url var="updateButton" value="">--%>
<%--            <c:param name="depId" value="${department.id}"/>--%>
<%--        </c:url>--%>
        <input type="submit" value="Back"/>
<%--        <input type="button" value="Update" onclick="window.location.href='${updateButton}'">--%>
    </form:form>

    </body>
</html>