<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Ajouter un véhicule
</button>
<%--<div class="container">--%>
    <%--<form method = "POST" action="/car/add">--%>
        <%--<fieldset>--%>
            <%--<legend>car information:</legend>--%>
            <%--Registration number:<br>--%>
            <%--<input type="text" name="registration_number"><br>--%>
            <%--Mark:<br>--%>
            <%--<input type="text" name="mark" ><br><br>--%>
            <%--tran:<br>--%>
            <%--<input type="text" name="registration_number"><br>--%>
            <%--mark:<br>--%>
            <%--<input type="text" name="mark" ><br><br>--%>
            <%--Registration number:<br>--%>
            <%--<input type="text" name="registration_number"><br>--%>
            <%--mark:<br>--%>
            <%--<input type="text" name="mark" ><br><br>--%>
            <%--<input type="submit" value="Submit">--%>
        <%--</fieldset>--%>
    <%--</form>--%>



    <%--<form class="form-horizontal" action="/add">--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="regristration_number">Registration number:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="regristration_number" placeholder="Enter registration number">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="mark">Mark:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="mark" placeholder="Enter mark">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="model_name">Model name:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="model_name" placeholder="Enter Model name">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="transmission">Transmission type:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="transmission" placeholder="Enter transmission type">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="nb_places">Number of places:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="nb_places" placeholder="Enter number of places">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="nb_doors">Number of doors:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="nb_doors" placeholder="Enter number of doors">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label class="control-label col-sm-2" for="category">Category:</label>--%>
            <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" id="category" placeholder="Enter category">--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group">--%>
            <%--<div class="col-sm-offset-2 col-sm-10">--%>
                <%--<button type="submit" class="btn btn-default">Add car</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form>--%>


        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ajouter un véhicule</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form:form method="POST" action="/car/add" modelAttribute="vehicule">


                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" path="registration_number"  class="form-control" required="required"/>
                            <form:label path="registration_number">Immatriculation</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-eur prefix grey-text"></i>
                            <form:input type="text" path="mark" class="form-control"/>
                            <form:label  data-error="Marque invalide" path="mark">Marque</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-eur prefix grey-text"></i>
                            <form:input type="text" path="model_name" class="form-control"/>
                            <form:label  data-error="modèle invalide" path="model_name" >Nom du modèle</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-eur prefix grey-text"></i>
                            <form:input type="text" path="transmission" class="form-control"/>
                            <form:label data-error="champs invalide" path="transmission" >Type de transmission</form:label>
                        </div>


                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                        <button type="submit" class="btn btn-primary">Ajouter un véhicule</button></form:form>
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