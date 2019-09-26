<%--
  Created by IntelliJ IDEA.
  User: Jess
  Date: 26/09/2019
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="full-height">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Erreurs médicamenteuses</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/css/mdb.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.10/js/mdb.min.js"></script>
    <style>
        .zoom {
            padding: 50px;
            background-color: green;
            transition: transform .2s; /* Animation */
            width: 300px;
            height: 200px;
            margin: 0 auto;
        }

        .zoom:hover {
            transform: scale(1.5); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
        }
    </style>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark indigo" >
        <a class="navbar-brand" href="">
            <img class="no-padding" id="logo" src ="https://media.discordapp.net/attachments/626528980320780308/626820356778491904/Jessi_logo_sans_fond.png" height="50"> Portail d'information sur les erreurs médicamenteuses
        </a>
        <button class="navbar-toggler" type="button"
                data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">

                </li>
            </ul>
        </div>
    </nav>
</header>
<br>
<br>
<br>
<br>
<center>
    <a class="btn btn-purple zoom"><i class="fas fa-hospital fa-3x"></i> Etablissement de santé</a>
    <a class="btn btn-deep-purple zoom" href="graphes.html"><i class="fas fa-home fa-3x"></i></i> Domicile</a>
    <a class="btn btn-indigo zoom"><i class="fas fa-city fa-3x"></i> Ville</a>
</center>
</body>
</body>
</html>
