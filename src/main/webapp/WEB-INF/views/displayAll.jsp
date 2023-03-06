<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
    <head>
        <style>

        </style>
    </head>
<body>
    <table>
        <tr>
            <th>Employee Id</th>
            <th>Employee Name</th>
            <th>Employee Salary</th>
        </tr>
        <c:forEach items="${empList}" var="e">
            <tr>
             <td>${e.id}</td>
             <td>${e.name}</td>
             <td>${e.salary}</td>
            </tr>
         </c:forEach>

    </table>
</body>
</html>