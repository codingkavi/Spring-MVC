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
        <c:forEach items="${employeeList}" var="emp">
            <tr>
             <td>${emp.id}</td>
             <td>${emp.name}</td>
             <td>${emp.salary}</td>
            </tr>
         </c:forEach>
         <c:set var ="str" value="Hello this a demo for JSTL">
                  Length is : ${fn:length(str)}
                  index : ${fn:indexOf(str,'is')}
                  contains: ${fn:contains(str,'demo')}
         <c:if test = "${fn:contains(str,'demo'}">
              using if condition to check string demo is there
         </c:if>
         <c:if test = "${fn:endsWith(str,'JSTL'}">
                      Ends with JSTL
         </c:if>
                ${fn:toUpperCase(str)}
         <c:forEach items= "${fn:split(str,'')}" var ="s"> <br>
              ${s}
         </c:forEach>
    </table>
</body>
</html>