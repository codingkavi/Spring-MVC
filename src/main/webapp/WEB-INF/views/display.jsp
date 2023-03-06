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

        <tr>
             <td>${emp.id}</td>
             <td>${emp.name}</td>
             <td>${emp.salary}</td>
        </tr>
    </table>
</body>
</html>