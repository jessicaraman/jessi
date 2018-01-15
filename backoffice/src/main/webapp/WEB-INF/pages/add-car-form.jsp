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
<!--/.Navbar-->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Ajouter un véhicule
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ajouter un véhicule</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <%--@elvariable id="car" type="fr.digicar.model.Car"--%>
            <form:form method="POST" action="${pageContext.request.contextPath}/car/add" modelAttribute="car">
                <div class="modal-body">

                    <div class="md-form">
                        <form:input type="text" path="registration_number" cssClass="form-control" required="required"/>
                        <form:label path="registration_number">Immatriculation</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="mark" cssClass="form-control"/>
                        <form:label data-error="Marque invalide" path="mark">Marque</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="name_model" cssClass="form-control"/>
                        <form:label data-error="modèle invalide" path="name_model">Nom du modèle</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="transmission" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="transmission">Type de transmission</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="nb_places" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="nb_places">Nombre de places</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="nb_doors" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="nb_doors">Nombre de portes</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="category" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="category">Catégorie</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="state" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="state">Emplacement</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="kilometers" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="kilometers">Kilométrage</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="release_date" cssClass="form-control"/>
                        <form:label data-error="champs invalide"
                                    path="release_date">Date de mise en circulation</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="comfort" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="comfort">Confort</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="fuel_type" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="fuel_type">Type de carburant</form:label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary">Ajouter un véhicule</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>