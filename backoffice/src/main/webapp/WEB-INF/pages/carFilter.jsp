<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Thierno
  Date: 14/01/2018
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
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
<!-- Modal -->

<%--@elvariable id="car" type="fr.digicar.model.Car"--%>
<form:form method="POST" action="${pageContext.request.contextPath}/car/add" modelAttribute="car">
    <div class="modal-body">
        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="registration_number" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="registration_number" data-error="Immatriculation invalide">Marque</form:label>
                <span class="input-group-addon waves-effect grey lighten-3" id="basic-addon1">
                    <a><i class="fa fa-search text-grey" aria-hidden="true"></i></a>
                </span>
            </div>
        </div>
    </div>
</form:form>

<form:form method="POST" action="${pageContext.request.contextPath}/car/all" modelAttribute="car">
    <div class="row">
        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="mark" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="mark" data-error="marque invalide">Marque</form:label>
            </div>
        </div>

        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="name_model" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="name_model" data-error="modèle invalide">Modèle</form:label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="kilometers" required="required" cssClass="form-control my-0 py-1 grey-border" type="number"/>
                <form:label path="kilometers">Marque</form:label>
            </div>
        </div>

        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="type" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="type" >Modèle</form:label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="transmission" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="transmission">Marque</form:label>
            </div>
        </div>

        <div class="col-md-3 mt-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="fuel_type" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="fuel_type">Modèle</form:label>
            </div>
        </div>
    </div>
    <div>
        <span>...</span>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">rechercher</button>
    </div>
</form:form>


<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>