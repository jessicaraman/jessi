<%--
  Created by IntelliJ IDEA.
  User: Jessica Ramanantsoa
  Date: 16/03/2018
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8" />
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style2.css" />" rel="stylesheet"/>
    <script src="<c:url value="/resources/js/live_search.js" />"></script>



</head>
<body>

<!--Navbar-->
<%@include file="header.jsp" %>

<div class="container">
    <br>
    <h4><img id="img_change" src="<c:url value="/resources/img/car.png" />"> Factures du 15 mars 2016 <img src="<c:url value="/resources/img/bike.png" />"></h4>
    <a href="#"><h5><img src="<c:url value="/resources/img/chevron.png"/> ">Autre date</h5></a>
    <input type="text" class="form-control form-control-lg" id="myInput" onkeyup="myFunction()" placeholder="Rechercher par nom de famille ...">

    <table id="myTable" class="table">

        <tr class="header table-warning">
            <th class="align-text-top" style="width:5%">Statut</th>
            <th style="width:22%;">Nom</th>
            <th style="width:22%;">Prénom</th>
            <th style="width:22%;">Abonnement</th>
            <th style="width:21%;"><img src="<c:url value="/resources/img/mail.png" />"></th>
            <th style="width:21%;"><img class="img_change" src="<c:url value="/resources/img/mobile-phone.png" />"></th>
            <th style="width:8%;">Facture</th>
        </tr>

        <tr>
            <td> <img src="gold.png"> </td>
            <td>Alfreds Futterkiste</td>
            <td>Germany</td>
            <td>Economique (depuis le 24 janvier 2012)</td>
            <td><a href="https://mail.google.com/mail/?view=cm&fs=1&to=user@domain.com&su=Votre%20Facture%20Digicar" target="blank_">user@domain.com</A></td>
            <td>0645123698</td>
            <td><a target="blank_" href="test.pdf"><img class="img_change" src="pdf.png"></a></td>
        </tr>
        <tr>
            <td></td>
            <td>Berglunds snabbkop</td>
            <td>Sweden</td>
            <td>Economique (depuis le 24 janvier 2012)</td>
            <td>user@email.com</td>
            <td>0645123698</td>
            <td><img class="img_change" src="pdf.png"></td>
        </tr>
        <tr>
            <td><img src="gold.png"></td>
            <td>Island Trading</td>
            <td>UK</td>
            <td>Economique (depuis le 24 janvier 2012)</td>
            <td>user@email.com</td>
            <td>0645123698</td>

            <td><img class="img_change" src="pdf.png"></td>
        </tr>
        <tr>
            <td></td>
            <td>Koniglich Essen</td>
            <td>Germany</td>
            <td>Economique (depuis le 24 janvier 2012)</td>
            <td>user@email.com</td>
            <td>0645123698</td>
            <td><img class="img_change" src="pdf.png"></td>
        </tr>
    </table>
</div>
</body>
</html>