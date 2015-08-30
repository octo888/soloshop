<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>

    <!-- Bootstrap CSS -->
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/includes/css/bootstrap-glyphicons.css"
          rel="stylesheet">

    <link href="${pageContext.request.contextPath}/resources/includes/css/styles.css" rel="stylesheet">

    <%--before any other javascript--%>
    <script src="${pageContext.request.contextPath}/resources/includes/js/modernizr-2.6.2.min.js"></script>


    <!-- Mobile viewport optimized -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<tilesx:useAttribute name="current"/>

<div class="container" id="main">

    <div class="navbar navbar-fixed-top" id="topNavbar" role="navigation">
        <div class="container">

            <button class="navbar-toggle"
                    data-target=".navbar-responsive-collapse" data-toggle="collapse"
                    type="button">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/index" id="logo"><img class="img-responsive"
                                                                     src="${pageContext.request.contextPath}/resources/images/logo.png"
                                                                     alt="Your Logo"></a>

            <form role="search" class="navbar-form pull-left searchForm" action="/search.html" method="post">
                <input type="text" name="pattern" class="form-control"
                       placeholder="Поиск..." id="searchInput">

                <button type="submit" class="btn btn-default">
                    <span class="glyphicon glyphicon-search"></span>
                </button>
            </form>
            <!-- navbar form -->

            <div class="nav-collapse collapse navbar-responsive-collapse">

                <ul class="nav navbar-nav pull-right">

                    <security:authorize access="hasRole('ROLE_ADMIN')">

                        <li class="dropdown"><a href="#" class="dropdown-toggle"
                                                data-toggle="dropdown">АдминПанель<strong class="caret"></strong></a>
                            <ul class="dropdown-menu">

                                <li class="${current == 'addbook' ? 'active' : '' }">
                                    <a href="<spring:url value="/admin/addbook.html" />">Добавить книгу</a></li>

                            </ul>
                        </li>
                    </security:authorize>

                    <li><a
                            href="<spring:url value="/index.html"/>">Главная</a></li>

                    <li><a href="#">
                        <span class="glyphicon glyphicon-shopping-cart"></span><strong>Корзина</strong>
                        <span class="badge">0</span></a>
                    </li>

                    <security:authorize access="! isAuthenticated()">
                        <li><a href="<spring:url value="/login">
                                </spring:url>">Войти</a></li>
                        <li><a href="<spring:url value="/register.html">
                                </spring:url>">Регистрация</a></li>
                    </security:authorize>

                    <security:authorize access="isAuthenticated()">
                        <li><a href="<spring:url value="/logout" />">Выйти</a></li>
                    </security:authorize>

                </ul>
                <!-- end nav pull right -->

            </div>
            <!-- end nav-collapse -->

        </div>
        <!-- end container -->
    </div>
    <!-- end navbar -->


    <%--Insert Body--%>
    <div class="wrapBody">
        <tiles:insertAttribute name="body"/>
    </div>

</div>
<%--end main container--%>


<%--Insert Footer--%>
<tiles:insertAttribute name="footer"/>

<script src="${pageContext.request.contextPath}/resources/includes/js/jquery-1.8.2.min.js"></script>

<!-- Bootstrap JS -->
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom JS -->
<script src="${pageContext.request.contextPath}/resources/includes/js/script.js"></script>

<script type="text/javascript"
        src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

</body>
</html>
