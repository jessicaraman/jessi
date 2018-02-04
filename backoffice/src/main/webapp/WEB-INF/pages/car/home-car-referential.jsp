<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CSC Inside</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
    <div class="header">
        <nav class="navbar navbar-expand-lg navbar-dark indigo">
            <a class="navbar-brand" href="<c:url value="/"/>">CSC Inside</a>
            <button class="navbar-toggler" type="button"
                    data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Véhicules</a>
                        <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="">Liste véhicule</a>
                            <a class="dropdown-item" href="<c:url value="/car/add"/>">Ajouter</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/parking"/>">Places de parking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/pricing"/>">Tarifs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/users"/>">Utilisateurs</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div>


    <%--@elvariable id="confirmationMessage" type="java.lang.String"--%>
    <c:if test="${not empty confirmationMessage}">
        <div class="row">
            <div class="alert alert-success w-100">${confirmationMessage}</div>
        </div>
    </c:if>
    <%--@elvariable id="alertMessage" type="java.lang.String"--%>
    <c:if test="${not empty alertMessage}">
        <div class="row">
            <div class="alert alert-warning w-100">${alertMessage}</div>
        </div>
    </c:if>
<div>

</div>
<%@include file="carFilter.jsp"%>

<%@include file="list-car.jsp"%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>