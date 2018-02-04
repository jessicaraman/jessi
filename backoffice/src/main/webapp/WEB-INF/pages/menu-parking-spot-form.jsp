<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
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
<div class="header">
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
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Véhicules</a>
                    <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="<c:url value="/car/"/>">Liste véhicule</a>
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
</div>
<!--/.Navbar-->

<div class="container">
    <button type="button" class="btn btn-primary mt-2" data-toggle="modal" data-target="#createModal">
        <i class="fa fa-plus mr-1"></i>
        Ajouter une place
    </button>

    <button type="button" class="btn btn-primary mt-2" data-toggle="modal" data-target="#searchModal">
        <i class="fa fa-plus mr-1"></i>
        Rechercher une place de parking
    </button>

    <!-- Modal AJOUTER-->
    <div class="modal fade mt-3" id="createModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="width:650px;">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ajouter une place</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--@elvariable id="parking" type="fr.digicar.model.ParkingSpot"--%>
                    <form:form method="POST" modelAttribute="parking" cssClass="m-5"
                               action="/parking/add">

                        <div class="md-form">
                            <i class="fa fa-car prefix grey-text"></i>
                            <form:input type="number" path="nbSpot" class="form-control" required="required"/>
                            <form:label path="nbSpot">Numero de place</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-sort-numeric-asc prefix grey-text"></i>
                            <form:input type="text" step="1" path="nbParking" class="form-control" required="required"/>
                            <form:label path="nbParking">Nom du parking</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:checkbox step="1" class="custom-control custom-checkbox" path="plug"/>
                            <form:label class="custom-control custom-checkbox" path="plug">Prise pour voiture éléctrique</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="location" class="form-control"
                                        required="required"/>
                            <form:label data-error="Ville invalide" path="location">Ville</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="longitude" class="form-control"
                                        required="required"/>
                            <form:label path="longitude">Coordonnées GPS-longitude</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="latitude" class="form-control"
                                        required="required"/>
                            <form:label path="latitude">Coordonnées GPS-latitude</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="longueur" class="form-control"
                                required="required"/>
                            <form:label path="longueur">Dimension Place-longueur</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="largeur" class="form-control"
                                        required="required"/>
                            <form:label path="largeur">Dimension Place-largeur</form:label>
                        </div>


                        <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary"><i class="fa fa-plus mr-1"></i>Ajouter place</button>
                </div>
                    </form:form>

            </div>
        </div>
    </div>
    </div>


    <!-- Modal SEARCH-->
    <div class="modal fade mt-3" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel2"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content" style="width:650px;">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel2">Rechercher une place</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--@elvariable id="parking" type="fr.digicar.model.ParkingSpot"--%>
                    <form:form method="POST" modelAttribute="parking" cssClass="m-5"
                               action="/parking/search">

                        <div class="md-form">
                            <i class="fa fa-car prefix grey-text"></i>
                            <form:input type="number" path="nbSpot" class="form-control"/>
                            <form:label path="nbSpot">Numero de place</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-sort-numeric-asc prefix grey-text"></i>
                            <form:input type="text" step="1" path="nbParking" class="form-control" />
                            <form:label path="nbParking">Nom du parking</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="text" step="1" path="location" class="form-control"/>
                            <form:label data-error="Ville invalide" path="location">Ville</form:label>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                            <button type="submit" class="btn btn-primary"><i class="fa fa-plus mr-1"></i>Rechercher place</button>
                        </div>
                    </form:form>

                </div>
            </div>
        </div>
    </div>


    <h3>Liste des places</h3>

    <c:if test="${!empty parkingSpot}">
        <table class="table table-hover">
            <tr>
                <th width="80">Id</th>
                <th width="120">Nom du parking</th>
                <th width="30">Numero de place</th>
                <th width="60">Prise electrique</th>
                <th width="100">Adresse</th>
                <th width="30">Longitude</th>
                <th width="30">Latitude</th>
                <th width="30">Longueur</th>
                <th width="30">Largeur</th>
                <th width="100"></th>
            </tr>
            <c:forEach items="${parkingSpot}" var="place">
                <c:if test="${!empty id} && ${place.id}==${id}">
                    <c:set value="table-success" var="cssClass"></c:set>
                </c:if>
                <tr class="${cssClass}">
                    <td>${place.id}</td>
                    <td>${place.nbParking}</td>
                    <td>${place.nbSpot}</td>
                    <td>${place.plug}</td>
                    <td>${place.location}</td>
                    <td>${place.longitude}</td>
                    <td>${place.latitude}</td>
                    <td>${place.longueur}</td>
                    <td>${place.largeur}</td>

                    <td>
                        <button class="btn btn-warning" data-toggle="modal" data-target="#editModal">Modifier</a>
                        </button>
                    </td>
                    <td>
                        <form:form method="GET" modelAttribute="parking" action="/parking/delete/${place.id}">
                        <button style="margin:0px" type="submit" class="btn btn-danger">Supprimer
                        </button>
                        </form:form>
                    </td>
                    <!-- Modal MODIFIER-->
                    <div class="modal fade mt-3" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel3"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content" style="width:650px;">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel3">Ajouter une place</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                        <%--@elvariable id="parking" type="fr.digicar.model.ParkingSpot"--%>
                                    <form:form method="POST" modelAttribute="parking" action="/parking/edit/${place.id}">

                                        <div class="md-form">
                                            <i class="fa fa-car prefix grey-text"></i>
                                            <form:input type="number" path="nbSpot" class="form-control" required="required"/>
                                            <form:label path="nbSpot">Numero de place</form:label>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                                            <button type="submit" class="btn btn-primary"><i class="fa fa-plus mr-1"></i>Modifier place</button>
                                        </div>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                    </div>

                </tr>

            </c:forEach>
        </table>
    </c:if>

    <br>




</div>



<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>