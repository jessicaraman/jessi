<%--
  Created by IntelliJ IDEA.
  User: Jessica
  Date: 08/12/2017
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<!--/.Navbar-->

<br>
<br>
<br>
 <div class="container">
     <form:form method="GET" action="/pricing/addPricing" modelAttribute="tarif">


     <div class="md-form">
        <i class="fa fa-user prefix grey-text"></i>
        <form:input type="text" path="libelle"  class="form-control"/>
        <form:label>Your name</form:label>
    </div>

    <div class="md-form">
        <i class="fa fa-envelope prefix grey-text"></i>
        <form:input type="text" path="prix_heure" class="form-control"/>
        <form:label>Your email</form:label>
    </div>

    <div class="md-form">
        <i class="fa fa-tag prefix grey-text"></i>
        <form:input type="text" path="prix_km" class="form-control"/>
        <form:label >Subject</form:label>
    </div>

         <p style="color:rgb(117, 117, 117);">Vehicule categories :</p>
     <%--    <div class="btn-group mr-4" data-toggle="buttons">

             <label class="btn btn-primary active">
                 <input type="checkbox" checked autocomplete="off"> Checkbox 1 (pre-checked)
             </label>

             <label class="btn btn-primary">
                 <input type="checkbox" autocomplete="off"> Checkbox 2
             </label>

             <label class="btn btn-primary">
                 <input type="checkbox" autocomplete="off"> Checkbox 3
             </label>

         </div> --%>
<br>
    <div class="text-center">
        <button type="submit" value="Submit" class="btn btn-unique">Add pricing <i class="fa fa-plus-square-o  ml-1"></i></button>

    </div>

     </form:form>
</div>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>