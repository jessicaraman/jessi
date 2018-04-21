<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
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
    <meta charset="utf-8"/>
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
    <br/>
    <h4>
        <img id="img_change" src="<c:url value="/resources/img/car.png" />"> Factures du
        <%!
            private String formatDate(Date d) {
                SimpleDateFormat formater = new SimpleDateFormat("dd MMMMM yyyy");
                return formater.format(d);
            }
        %>
        <%= formatDate(new Date()) %>
        <img src="<c:url value="/resources/img/bike.png" />">
    </h4>
    <a href="#">
        <h5>
            <img src="<c:url value="/resources/img/chevron.png"/>">
            Autre date
        </h5>
    </a>

    <c:choose>
        <%--@elvariable id="invoices" type="java.util.List"--%>
        <c:when test="${empty invoices}">
            <p style="text-align:center;"> Factures non générées <a href="<c:url value="/algo" />">
                <button class="btn btn-sm btn-primary">
                    Générer
                </button>
            </a></p>
        </c:when>
        <c:otherwise>
            <input type="text" class="form-control form-control-lg" id="myInput" onkeyup="myFunction()"
                   placeholder="Rechercher par nom de famille ...">

            <table id="myTable" class="table">
                <tr class="header table-warning">
                    <th class="align-text-top" style="width:5%">Statut</th>
                    <th style="width:22%;">Nom</th>
                    <th style="width:22%;">Prénom</th>
                    <th style="width:22%;">Abonnement</th>
                    <th style="width:21%;">
                        <img src="<c:url value="/resources/img/mail.png" />">
                    </th>
                    <th style="width:21%;">
                        <img class="img_change" src="<c:url value="/resources/img/mobile-phone.png" />">
                    </th>
                    <th style="width:8%;">Facture</th>
                </tr>
                    <%--@elvariable id="users" type="java.util.List"--%>
                    <%--@elvariable id="user" type="fr.digicar.model.User"--%>
                <c:forEach items="${users}" var="user">
                    <%--@elvariable id="subscriptions" type="java.util.List"--%>
                    <%--@elvariable id="sub" type="fr.digicar.model.Subscription"--%>
                    <c:forEach items="${subscriptions}" var="sub">
                        <%--@elvariable id="tarifs" type="java.util.List"--%>
                        <%--@elvariable id="tarif" type="fr.digicar.model.Tarif"--%>
                        <c:forEach items="${tarifs}" var="tarif">
                            <%--@elvariable id="inv" type="fr.digicar.model.Invoice"--%>
                            <c:forEach items="${invoices}" var="inv">
                                <c:if test="${user.id==sub.id_user}">
                                    <c:if test="${sub.id_pricing==tarif.id}">
                                        <c:if test="${sub.id_user==inv.user}">
                                            <tr>
                                                <td>
                                                    <img src="<c:url value="/resources/img/gold.png" />">
                                                </td>
                                                <td>${user.lastName}</td>
                                                <td>${user.firstName}</td>
                                                <td>${tarif.libelle}</td>
                                                <td>${user.email}</td>
                                                <td>${user.phoneNumber}
                                                <td>
                                                    <%--@elvariable id="desktop" type="java.lang.String"--%>
                                                    <a target="_blank" href="file:///${desktop}${inv.url}">
                                                        <img src="<c:url value="/resources/img/pdf.png" />">
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>