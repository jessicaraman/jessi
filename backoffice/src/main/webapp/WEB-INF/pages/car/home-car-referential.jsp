<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CSC - BackOffice</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
    <div class="header">
        <nav class="navbar navbar-expand-lg navbar-dark indigo">
            <a class="navbar-brand" href="#">CSC Inside</a>
            <button class="navbar-toggler" type="button"
                    data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Maintain vehicle referential<span class="sr-only">(current)</span></a>
                        <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="">Liste véhicule</a>
                            <a class="dropdown-item" href="<c:url value="/car/add"/>">Ajouter</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/parking/add"/>">Maintain parking spot referential</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/pricing"/>">Maintain pricing referential</a>
                    </li>

                </ul>
            </div>
        </nav>
    </div>


    <%--@elvariable id="confirmationMessage" type="java.lang.String"--%>
    <c:if test="${not empty confirmationMessage}">
        <div class="row">
            <div class="alert alert-success w-50">${confirmationMessage}</div>
        </div>
    </c:if>
    <%--@elvariable id="alertMessage" type="java.lang.String"--%>
    <c:if test="${not empty alertMessage}">
        <div class="row">
            <div class="alert alert-warning w-50">${alertMessage}</div>
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