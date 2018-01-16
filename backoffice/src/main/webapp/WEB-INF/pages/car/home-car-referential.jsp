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
                    <a class="dropdown-item" href="<c:url value="/car/addCarPage"/>">Ajouter</a>
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
<%@include file="carFilter.jsp"%>

<h3 class="text-center">Liste des véhicules</h3>

<div class="table">
<c:if test="${!empty cars}">
    <table class="table table-hover">
        <tr>
            <th width="80">Immatriculation</th>
            <th width="120">Marque</th>
            <th width="120">Nom du modèle</th>
            <th width="60">Type de transmission</th>
            <th width="60">Nombre de places</th>
            <th width="100">Nombre de portes</th>
            <th width="100">Type de véhicule</th>
            <th width="100">Emplacement</th>
            <th width="10">Kilométrage</th>
            <th width="60">Date de mise en circulation</th>
            <th width="10">Confort</th>
            <th width="50">Type de carburant</th>
        </tr>
        <c:forEach items="${cars}" var="car">
            <tr>
                <td>${car.registration_number}</td>
                <td>${car.mark}</td>
                <td>${car.name_model}</td>
                <td>${car.transmission}</td>
                <td>${car.nb_places}</td>
                <td>${car.nb_doors}</td>
                <td>${car.type}</td>
                <td>${car.location}</td>
                <td>${car.kilometers}</td>
                <td>${car.release_date}</td>
                <td>${car.comfort}</td>
                <td>${car.fuel_type}</td>
                <td><button class="btn btn-warning" style="margin: 0px;"><a href="<c:url value='' />" >Modifier</a></button></td>
                <td><button style="margin:0px" class="btn btn-danger"><a href="<c:url value='' />" >Supprimer</a></button></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>