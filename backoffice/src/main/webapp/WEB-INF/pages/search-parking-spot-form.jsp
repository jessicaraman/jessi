<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CarSharingClub - BackOffice</title>
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
    <code>Search parking spot</code>

    <%--@elvariable id="searchparking" type="fr.digicar.model.ParkingSpot"--%>
    <form:form method="POST" modelAttribute="searchparking" cssClass="m-5" action="/parking/search">




        <div class="row mt-2">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="number" id="id" cssClass="form-control validate" path="id"
                                required="required"/>
                    <form:label for="id" path="id">
                        Numéro de Place
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="number" id="nbSpot" cssClass="form-control validate" path="nbSpot"
                                />
                    <form:label for="nbSpot" data-error="Numéro de place déjà attribué" path="nbSpot">
                        Numéro de Place

                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="number" id="nbParking" cssClass="form-control validate" path="nbParking"
                                />
                    <form:label for="nbParking" data-error="Ce parking n'existe pas" path="nbParking">
                        Numéro de Parking

                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <label class="custom-control custom-checkbox" path="plug">
                        <input type="checkbox" class="custom-control-input" path="plug">
                        <span class="custom-control-indicator"></span>
                        <span class="custom-control-description">Prise pour voiture éléctrique</span>
                    </label>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="text" id="location" cssClass="form-control validate" path="location"
                                />
                    <form:label for="location" data-error="Renseignez la ville ou se situe le parking" path="location">
                        Ville

                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col text-right">
                <button type="submit" class="btn btn-primary">
                    RECHERCHER &nbsp;
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