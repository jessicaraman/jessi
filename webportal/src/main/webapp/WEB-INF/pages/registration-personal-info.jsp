<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>S'enregistrer - CarSharingClub</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark indigo">
    <a class="navbar-brand" href="<c:url value="/"/>">CarSharingClub</a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/"/>">Accueil</a>
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
    <form:form method="POST" modelAttribute="user" cssClass="m-5"
               action="${pageContext.request.contextPath}/registration/confirm">
        <div class="row">
            <a class="btn btn-sm btn-default col disabled" href="<c:url value="/registration"/>">Identifiants</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-default col disabled">Informations personnelles</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-blue-grey col disabled">Activation</a>
        </div>
        <div class="row mt-4">
            <h1>Informations personnelles</h1>
        </div>
        <div class="row mt-2">
            <div class="col-2 pt-3">
                <div class="form-group w-100">
                    <form:select cssClass="form-control w-100 validate" path="gender" required="required">
                        <form:option value="" disabled="true" selected="true">Civilité</form:option>
                        <form:option value="Mme">Mme</form:option>
                        <form:option value="M.">M.</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-5">
                <div class="md-form">
                    <form:input type="text" id="firstname" cssClass="form-control validate" path="firstName"
                                required="required"/>
                    <form:label for="firstname" path="">
                        Prénom
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
            <div class="col-5">
                <div class="md-form">
                    <form:input type="text" id="lastname" cssClass="form-control validate" path="lastName"
                                required="required"/>
                    <form:label for="lastname" path="lastName">
                        Nom
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-4">
                <div class="md-form">
                    <form:input type="text" onfocus="(this.type='date')" id="birthdate" cssClass="form-control validate"
                                path="birthdateString" required="required"/>
                    <form:label for="birthdate" path="birthdateString">
                        Date de naissance
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
            <div class="col-8">
                <div class="md-form">
                    <form:input type="text" id="phone" cssClass="form-control validate" path="phoneNumber"
                                required="required"/>
                    <form:label for="phone" path="phoneNumber">
                        Numéro de téléphone
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-12">
                <div class="md-form">
                    <form:input type="text" id="addressline1" cssClass="form-control" path="addressLine1"
                                required="required"/>
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
                    <form:input type="text" id="addressline2" cssClass="form-control" path="addressLine2"/>
                    <form:label for="addressline2"
                                path="addressLine2">Complément d'adresse (immeuble, étage, etc.)</form:label>
                </div>
            </div>
        </div>
        <div class="row mt-1">
            <div class="col-4">
                <div class="md-form">
                    <form:input type="text" id="zipcode" cssClass="form-control" path="zipCode" required="required"/>
                    <form:label for="zipcode" path="zipCode">
                        Code postal
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
            <div class="col-8">
                <div class="md-form">
                    <form:input type="text" id="city" cssClass="form-control" path="city" required="required"/>
                    <form:label for="city" path="city">
                        Ville
                        <span class="text-danger">*</span>
                    </form:label>
                </div>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <a type="button" class="btn btn-light-blue" href="<c:url value="/registration"/>">
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
