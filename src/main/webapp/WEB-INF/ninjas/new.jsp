<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="
    <c:url value="/resources/css/sketchy.css" />
    " rel="stylesheet">
    <title>New Ninja</title>
  </head>
  <body>
    <div class="container">
      <h1>New Ninja</h1>
      <div class="container">
        <form:form action="/ninjas" method="post" modelAttribute="ninja">

          
            <form:label path="dojo" class="form-label mt-4">Dojo</form:label>
            <form:select path="dojo">
              <c:forEach var="dojo" items="${dojos}">
                <form:option value="${dojo.id}">${dojo.name}</form:option>
              </c:forEach>
            </form:select>
          

          <div class="form-group">
            <form:label path="firstName" class="form-label mt-4"
              >First Name:</form:label
            >
            <form:input path="firstName" class="form-control"></form:input>
          </div>

          <div class="form-group">
            <form:label path="lastName" class="form-label mt-4"
              >Last Name:</form:label
            >
            <form:input path="lastName" class="form-control"></form:input>
          </div>

          <div class="form-group">
            <form:label path="age" class="form-label mt-4">Age:</form:label>
            <form:input path="age" class="form-control"></form:input>
          </div>

          <button class="btn btn-primary mt-4">Create Ninja</button>
        </form:form>
      </div>
    </div>
  </body>
</html>
