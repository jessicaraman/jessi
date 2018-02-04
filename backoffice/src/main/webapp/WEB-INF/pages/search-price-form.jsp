<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jessica
  Date: 02/02/2018
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<br>
<div class="container">
    <a href="<c:url value="/pricing"/>" class="btn btn-primary">Ajout/Liste des Tarifs</a>
    <form:form class="form-inline"  action="/pricing/searchs" method="POST">

        <div class="md-form form-group">
            <i class="fa fa-tag prefix grey-text"></i>
            <input type="text" name="libelle" class="form-control"/>
            <label>Libellé</label>
        </div>

        <div class="md-form form-group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input type="number" step="1" name="frais_mensuels_min" class="form-control"/>
            <label data-error="Montant invalide">Frais mensuels min</label>
        </div>

        <div class="md-form form-group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input type="number" step="1" name="frais_mensuels_max" class="form-control" />
            <label data-error="Montant invalide">Frais mensuels max</label>
        </div>
        <div class="md-form form-group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input name="prix_heure_min" type="number" step="0.01" class="form-control"/>
            <label data-error="Montant invalide">Prix par heure minimal</label>
        </div>

        <div class="md-form form-group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input name="prix_heure_max" type="number" step="0.01" class="form-control"/>
            <label data-error="Montant invalide">Prix par heure maximal</label>
        </div>

        <div class="md-form form_group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input name="prix_km_min" type="number" step="0.01" class="form-control" />
            <label data-error="Montant invalide">Prix par km min</label>
        </div>

        <div class="md-form form_group">
            <i class="fa fa-eur prefix grey-text"></i>
            <input name="prix_km_max" type="number" step="0.01" class="form-control"/>
            <label data-error="Montant invalide" >Prix par km max</label>
        </div>

        <button type="submit" class="btn btn-primary"><i class="fa fa-search mr-1"></i>Rechercher tarif</button>
        <br>
        <table class="table table-hover">
            <tr>
                <th width="30">Id</th>
                <th width="120">Libelle</th>
                <th width="60">Prix par heure(€)</th>
                <th width="60">Prix par km(€)</th>
                <th width="60">Frais mensuels(€)</th>
            </tr>
            <c:choose>
                <c:when test="${!empty foundPrices}">
                    <c:forEach items="${foundPrices}" var="tarif">
                        <tr>
                            <td>${tarif.id}</td>
                            <td>${tarif.libelle}</td>
                            <td>${tarif.prix_heure}</td>
                            <td>${tarif.prix_km}</td>
                            <td>${tarif.frais_mensuels}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>Aucun résultat pour l'instant ...</tr>
                </c:otherwise>
            </c:choose>
        </table>
        </table>
        </table>
    </form:form>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>