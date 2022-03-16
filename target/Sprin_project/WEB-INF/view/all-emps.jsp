<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <body>
    <h2>Employees INFO table:</h2>
    <br><br>
    <table>
        <colgroup>
            <col style="background-color:LightCyan"><!-- Задаем цвет фона для следующего (одного) столбца таблицы-->
            <col style="background-color:antiquewhite">
            <col style="background-color:LightCyan">
            <col style="background-color:antiquewhite">
            <col style="background-color:LightCyan">
            <col style="background-color:antiquewhite">
        </colgroup>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Department_id</th>
            <th>Detail_id</th>
            <th>Salary</th>
        </tr>

        <c:forEach var="emp" items="${allEmployees}">

            <tr>
                <c:url var="detailButton" value="/getDetail">
                    <c:param name="detailId" value="${emp.detail_id.id}"/>
                </c:url>
                <c:url var="departButton" value="/getDepartment">
                    <c:param name="depId" value="${emp.department.id}"/>
                </c:url>
                <c:url var="updateButton" value="/updateInfo">
                    <c:param name="empId" value="${emp.id}"/>
                </c:url>
                <c:url var="deleteButton" value="/deleteEmployee">
                    <c:param name="empId" value="${emp.id}"/>
                </c:url>

                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.department.id}</td>
                <td>${emp.detail_id.id}</td>
                <td>${emp.salary}</td>
                <td>
                    <input type="button" value="Detail" onclick="window.location.href='${detailButton}'"/>
                    <input type="button" value="Depart" onclick="window.location.href='${departButton}'"/>
<%--                    <security:authorize access="hasRole('ADMIN')">--%>
                    <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>
<%--                    </security:authorize>--%>
<%--                    <security:authorize access="hasRole('ADMIN')">--%>
                    <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
<%--                    </security:authorize>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <c:url var="Add" value="/createNewEmployee"/>
<%--    <security:authorize access="hasRoles('ADMIN', 'MANAGER')">--%>
    <input type="button" value="Add new employee" onclick="window.location.href='${Add}'" >
<%--    </security:authorize>--%>
    </body>
</html>