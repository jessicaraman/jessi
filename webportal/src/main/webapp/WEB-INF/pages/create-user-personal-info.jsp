<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Create account</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark indigo">
    <a class="navbar-brand" href="#">Digicar</a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="#">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Fonctionnalités</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Tarifs</a>
            </li>

        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Rechercher" aria-label="Search">
        </form>
    </div>
</nav>
<!--/.Navbar-->

<div class="container">
    <%--@elvariable id="user" type="fr.digicar.model.User"--%>
    <form:form method="POST" modelAttribute="user" class="m-5"
               action="${pageContext.request.contextPath}/user/new/info">
        <div class="row">
            <a class="btn btn-sm btn-default col disabled">Identifiants</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-default col disabled">Informations personnelles</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-blue-grey col disabled">Activation</a>
        </div>
        <div class="row">
            <h1>Informations personnelles</h1>
        </div>
        <div class="row mt-2">
            <div class="col-2 pt-3">
                <form:select class="custom-select w-100" path="gender">
                    <form:option value="" disabled="true" selected="true">Civilité</form:option>
                    <form:option value="Mme">Mme</form:option>
                    <form:option value="M.">M.</form:option>
                </form:select>
            </div>
            <div class="col-5">
                <div class="md-form">
                    <form:input type="text" id="firstname" class="form-control" path="firstName"/>
                    <form:label for="firstname" path="">
                        Prénom
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
            <div class="col-5">
                <div class="md-form">
                    <form:input type="text" id="lastname" class="form-control" path="lastName"/>
                    <form:label for="lastname" path="lastName">
                        Nom
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="text" id="addressline1" class="form-control" path="addressLine1"/>
                    <form:label for="addressline1" path="addressLine1">
                        Adresse
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="text" id="addressline2" class="form-control" path="addressLine2"/>
                    <form:label for="addressline2"
                                path="addressLine2">Complément d'adresse (immeuble, étage, etc.)</form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-4">
                <div class="md-form">
                    <form:input type="text" id="zipcode" class="form-control" path="zipCode"/>
                    <form:label for="zipcode" path="zipCode">
                        Code postal
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
            <div class="col-8">
                <div class="md-form">
                    <form:input type="text" id="city" class="form-control" path="city"/>
                    <form:label for="city" path="city">
                        Ville
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <a type="button" class="btn btn-light-blue" href="${pageContext.request.contextPath}/user/new">
                    <i class="fa fa-angle-left"></i>
                    Retour &nbsp;
                </a>
            </div>
            <div class="col-6 text-right">
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
