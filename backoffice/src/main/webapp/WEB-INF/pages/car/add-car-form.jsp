<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CSC - BackOffice</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
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
                    <a class="dropdown-item" href="<c:url value="/car/"/>">Liste véhicule</a>
                    <a class="dropdown-item" href="">Ajouter</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/parking/add"/>">Maintain parking spot referential</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/pricing"/>">Maintain pricing referential</a>
            </li>

        </ul>
        <%--<form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        </form>--%>
    </div>
</nav>

<div>

</div>
<%--
<!--/.Navbar-->
<div class="row">
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Ajouter un véhicule
</button>
</div>

<!-- Modal -->
<div class="modal fade" id="" tabindex="" role="" aria-labelledby=""
     aria-hidden="">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ajouter un véhicule</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

     --%>
<div class="container">
    <h5 class="modal-title text-center" id="exampleModalLabel">Ajouter un véhicule</h5>
<%--@elvariable id="car" type="fr.digicar.model.Car"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/car/adding" modelAttribute="car">
        <div class="modal-body">

            <div class="md-form">
                <form:input type="text" path="registration_number" cssClass="form-control" required="required"/>
                <form:label path="registration_number">Immatriculation</form:label>
            </div>

            <div class="md-form">
                <form:input type="text" path="mark" cssClass="form-control"/>
                <form:label data-error="Marque invalide" path="mark">Marque</form:label>
            </div>

            <div class="md-form">
                <form:input type="text" path="name_model" cssClass="form-control"/>
                <form:label data-error="modèle invalide" path="name_model">Nom du modèle</form:label>
            </div>

            <div class="md-form">
                <form:label path="transmission" >Transmission</form:label>
                <form:select cssClass="form-control" path="transmission">
                    <option value="" disabled="true" >Choisir un type</option>
                    <c:forEach items="${listOfTransmissionMode}" var="transmissionMode" >
                        <option value=${transmissionMode.id} >${transmissionMode.name}</option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="md-form">
                <form:input type="number" path="nb_places" cssClass="form-control"/>
                <form:label data-error="champs invalide" path="nb_places">Nombre de places</form:label>
            </div>

            <div class="md-form">
                <form:input type="number" path="nb_doors" cssClass="form-control"/>
                <form:label data-error="champs invalide" path="nb_doors">Nombre de portes</form:label>
            </div>

            <div class="md-form">
                <form:label path="type" >Type de véhicule</form:label>
                <form:select cssClass="form-control" path="type">
                    <option value="" disabled="true" >Choisir un type</option>
                    <c:forEach items="${listOfCarType}" var="carType" >
                        <option value=${carType.id} >${carType.name}</option>
                    </c:forEach>
                </form:select>
            </div>

            <div class="md-form">
                <form:input type="text" path="location" cssClass="form-control"/>
                <form:label data-error="champs invalide" path="location">Emplacement</form:label>
            </div>

            <div class="md-form">
                <form:input type="number" path="kilometers" cssClass="form-control"/>
                <form:label data-error="champs invalide" path="kilometers">Kilométrage</form:label>
            </div>

            <div class="md-form">
                <form:input type="date" path="release_date" cssClass="form-control"/>
                <form:label data-error="champs invalide"
                            path="release_date">Date de mise en circulation</form:label>
            </div>

            <div class="md-form">
                <form:input type="text" path="comfort" cssClass="form-control"/>
                <form:label data-error="champs invalide" path="comfort">Confort</form:label>
            </div>

            <div class="md-form">
                <form:label path="fuel_type" >Carburant</form:label>
                <form:select cssClass="form-control" path="fuel_type">
                    <option value="" disabled="true" >Choisir un type</option>
                    <c:forEach items="${listOfFuelType}" var="fuelType" >
                        <option value=${fuelType.id} >${fuelType.name}</option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="">Annuler</button>
            <button type="submit" class="btn btn-primary">Ajouter un véhicule</button>
        </div>
    </form:form>
</div>
<%@include file="car-details.jsp"%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>

