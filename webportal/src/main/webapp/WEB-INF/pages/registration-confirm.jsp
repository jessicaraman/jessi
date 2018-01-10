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
<header>
    <nav class="navbar navbar-expand-lg navbar-dark elegant-color-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value="/"/>">CarSharingClub</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
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
        </div>
    </nav>
</header>

<div class="container">
    <div class="m-5 text-center">
        <div class="row">
            <a class="btn btn-sm btn-default col">Identifiants</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-default col">Informations personnelles</a>
            <hr class="col-2"/>
            <a class="btn btn-sm btn-default col">Activation</a>
        </div>
        <div class="row mt-5">
            <div class="col">
                <h1 class="display-1">
                    <i class="fa fa-check-circle-o text-success"></i>
                </h1>
                <h1>
                    Bienvenue chez CarSharingClub !
                </h1>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col">
                <h4 class="col">
                    Un courriel vient de vous être envoyé pour activer votre compte.<br/>
                    Vérifiez votre boîte de réception...
                </h4>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col">
                <button class="btn btn-lg btn-success">
                    Accéder au site
                </button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>
