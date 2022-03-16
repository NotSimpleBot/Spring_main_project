<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
    <h2>Employee detail:</h2>
    <br><br>
    <form:form action="redirectToStartPage" modelAttribute="detail">
        <c:url var="updateButton" value="/updateDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>
        <strong>Employee ID: </strong> ${detail.employee.id}
        <br>
        <strong>Surname: </strong>${detail.employee.surname}
        <br><br>
        <strong>Email: </strong>${detail.email}
        <br>
        <strong>Phone number: </strong>${detail.phone_number}
        <br>
        <strong>Country: </strong>${detail.country}
        <br><br>
        <input type="submit" value="Back">
        <input type="button" value="Update" onclick="window.location.href='${updateButton}'">
    </form:form>
    </body>
</html>