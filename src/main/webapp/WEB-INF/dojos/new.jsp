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
    <title>New Dojo</title>
  </head>
  <body>
    <div class="container">
      <h1>New Dojo</h1>
      <div class="container">
        <form:form action="/dojos" method="post" modelAttribute="dojo">
          <div class="form-group">
            <div class="form-group">
              <form:label path="name" class="form-label mt-4">Name:</form:label>
              <form:input path="name" class="form-control"></form:input>
            </div>
          </div>
          <button class="btn btn-primary mt-4">Create Dojo</button>
        </form:form>
      </div>
    </div>
  </body>
</html>
