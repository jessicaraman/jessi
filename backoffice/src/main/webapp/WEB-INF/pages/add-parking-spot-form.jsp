<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CarSharingClub - BackOffice</title>
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
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Pricing</a>
            </li>

        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        </form>
    </div>
</nav>
<!--/.Navbar-->

<div class="container">
    <%--@elvariable id="parking" type="fr.digicar.model.ParkingSpot"--%>
    <form:form method="POST" modelAttribute="parking" cssClass="m-5"
               action="${pageContext.request.contextPath}/add-parking-spot-form">
        <div class="row">
            <a class="btn btn-sm btn-default col">Identifiants</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-blue-grey col">Informations personnelles</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-blue-grey col">Activation</a>
        </div>
        <div class="row mt-4">
            <h1>Créer une place de parking</h1>
        </div>
        <%--@elvariable id="message" type="java.lang.String"--%>
        <c:if test="${not empty message}">
            <div class="row">
                <div class="alert alert-danger w-100">${message}</div>
            </div>
        </c:if>
        <div class="row mt-2">
            <div class="col-12">
                <div class="md-form">
                    <i class="fa fa-envelope prefix text-info"></i>
                    <form:input type="text" id="nbSpot" cssClass="form-control validate" path="nbSpot"
                                required="required"/>
                    <form:label for="nbSpot" data-error="Numéro de place déjà attribué" path="nbSpot">
                        Numéro de Place
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <i class="fa fa-lock prefix text-info"></i>
                    <form:input type="text" id="nbParking" cssClass="form-control validate" path="nbParking"
                                 required="required"/>
                    <form:label for="nbParking" data-error="Ce parking n'existe pas" path="nbParking">
                        Numéro de Parking
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <i class="prefix"></i>
                    <form:input type="checkbox" id="electricPlug" cssClass="form-control validate" path="electricPlug"
                                required="required"/>
                    <form:label for="electricPlug"  path="electricPlug">
                        Prise pour voiture électrique
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <i class="fa fa-lock prefix text-info"></i>
                    <form:input type="text" id="location" cssClass="form-control validate" path="location"
                                required="required"/>
                    <form:label for="location" data-error="Renseignez la ville ou se situe le parking" path="location">
                        Ville
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col text-right">
                <button type="submit" class="btn btn-primary">
                    Suivant &nbsp;
                    <i class="fa fa-angle-right"></i>
                </button>
            </div>
        </div>
    </form:form>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>