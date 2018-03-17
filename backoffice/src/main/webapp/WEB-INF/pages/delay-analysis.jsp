<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CSC Inside</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark indigo">
    <a class="navbar-brand" href="<c:url value="/"/>">CSC Inside</a>
    <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Véhicules</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<c:url value="/car/"/>">Liste des véhicules</a>
                    <a class="dropdown-item" href="<c:url value="/car/add"/>">Ajouter</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/parking"/>">Places de parking</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/pricing"/>">Tarifs</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/users"/>">Utilisateurs</a>
            </li>
        </ul>
    </div>
</nav>

<div class="m-3">
    &nbsp;
</div>

<section class="container mt-5">
    <div class="row">
        <div class="card col-5 container" style="margin: auto;">
            <div class="card-body row">
                <div class="col-3 text-center" style="border-right: 1px solid darkgrey;">
                    <h1 class="display-2"><i class="fa fa-clock-o" aria-hidden="true"></i></h1>
                </div>
                <div class="col-9">
                    <%--@elvariable id="delayNumber" type="int"--%>
                    <h4 class="card-title"><strong>${delayNumber}</strong></h4>
                    <h5>RETARDS ENREGISTRÉS</h5>
                    <p class="card-text">Février - Mars 2018</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-5">
        <canvas id="quartiles" class="col" style="max-width: 600px; margin: auto;"></canvas>
    </div>
</section>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
<script type="text/javascript">
    var ctx = document.getElementById("quartiles").getContext('2d');
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Q1", "Q2", "Q3", "Q4"],
            datasets: [{
                label: 'Répartition des retards',
                data: [12, 19, 3, 5],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });
</script>
</body>
</html>
