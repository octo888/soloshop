<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>

<link href="${pageContext.request.contextPath}/resources/includes/css/signin.css" rel="stylesheet">

<form class="form-signin" role="form" action="<spring:url value="/login" />" method="POST">
  <h2 class="form-signin-heading">Пожалуйста ввойдите</h2>
  <input type="text" name="username" class="form-control" placeholder="Login" required autofocus>
  <input type="password" name="password" class="form-control" placeholder="Password" required>
    <%--<input type="hidden"
           name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>