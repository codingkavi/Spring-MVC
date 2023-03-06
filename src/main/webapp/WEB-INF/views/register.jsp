<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Register Employee Details</title>
    <style>
    .error{
    color:red
    }
    </style>

</head>
<body>
<div align="center">
    <form:form action="registerEmp"
          method="post"
          modelAttribute="validationModel">
        <div>
        <div>
            Id: <form:input type="text" name="id" path="id" />
            <form:errors path="id" cssClass="error"/>
        </div>
        <div>
            Name:<form:input type="text" name="name" path="name" />
                <form:errors path="name" cssClass="error"/>
        </div>
        <div>
            Salary:<form:input type="text" name="salary" path="salary" />
                    <form:errors path="salary" cssClass="error"/>
                    <input type="submit" value="Register"/>
        </div>
      </div>
    </form:form>
</div>
</body>
</html>