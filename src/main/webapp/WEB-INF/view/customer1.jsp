<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type=text]{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  width : 50%;
  margin : auto;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.error{
  color: red;
}

</style>
</head>
<body>


 <div>
 
<h1>Customer</h1>

<form:form action= "process-insert" modelAttribute="customer">

  <form:label path="user_name">User name : </form:label>
  <form:input path="user_name"/>
  
  <br>
  
  <form:label path="password">Password : </form:label>
  <form:input path="password"/>
  
  <br>
  
  <form:label path="email">Email : </form:label>
  <form:input path="email"/> 
  
  <br>
  <form:errors path="user_name" class= "error"></form:errors>
  <br>
  <form:errors path="password" class= "error"></form:errors>
  <br>
  <form:errors path="email" class= "error"></form:errors>
  
  
    
  <input type = "submit" value= "Submit">  
</form:form>
 </div>

</body>
</html>