<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="full-height">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CarSharingClub</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
    <style>
        .intro-1 {
            background: url(<c:url value="/resources/img/carsharingclub.jpg"/>) no-repeat center center;
            background-size: cover;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark elegant-color-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">CarSharingClub</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
        </div>
    </nav>
    <section class="view intro-1 hm-black-strong">
        <div class="full-bg-img flex-center">
            <div class="container">
                <ul>
                    <li>
                        <h1 class="h1-responsive font-bold wow fadeInDown" data-wow-delay="0.2s">Réservez une voiture
                            pour vos déplacements quotidiens.</h1></li>
                    <li>
                        <p class="lead mt-4 mb-5 wow fadeInDown">Réalisez vos trajets avec l'autopartage de
                            CarSharingClub et faites des économies sur vos déplacements !</p>
                    </li>
                    <li>
                        <a href="<c:url value="/registration"/>"
                           class="btn btn-primary btn-lg wow fadeInLeft" data-wow-delay="0.2s"
                           rel="nofollow">S'inscrire</a>
                        <a href="<c:url value="/login"/>"
                           class="btn btn-default btn-lg wow fadeInRight" data-wow-delay="0.2s" rel="nofollow">Se
                            connecter</a>
                    </li>
                </ul>
            </div>
        </div>
    </section>
</header>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
<script>
    new WOW().init();
</script>
</body>
</html>