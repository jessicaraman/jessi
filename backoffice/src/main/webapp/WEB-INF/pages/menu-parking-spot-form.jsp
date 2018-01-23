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
                            <form:input type="number" step="1" path="nbParking" class="form-control" required="required"/>
                            <form:label path="nbParking">Numero de parking</form:label>
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
                    <h5 class="modal-title" id="exampleModalLabel2">Recherchers une place</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <%--@elvariable id="parking" type="fr.digicar.model.ParkingSpot"--%>
                    <form:form method="POST" modelAttribute="parking" cssClass="m-5"
                               action="/parking/search">

                        <div class="md-form">
                            <i class="fa fa-tag prefix grey-text"></i>
                            <form:input type="number" path="id" class="form-control"/>
                            <form:label path="id">IDENTIFIANT EN BASE de place</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-car prefix grey-text"></i>
                            <form:input type="number" path="nbSpot" class="form-control"/>
                            <form:label path="nbSpot">Numero de place</form:label>
                        </div>

                        <div class="md-form">
                            <i class="fa fa-sort-numeric-asc prefix grey-text"></i>
                            <form:input type="number" step="1" path="nbParking" class="form-control" />
                            <form:label path="nbParking">Numero de parking</form:label>
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
                <th width="120">Numero de place</th>
                <th width="60">Numero de parking</th>
                <th width="60">Prise electrique</th>
                <th width="60">Ville</th>
                <th width="100"></th>
            </tr>
            <c:forEach items="${parkingSpot}" var="place">
                <c:if test="${!empty id} && ${place.id}==${id}">
                    <c:set value="table-success" var="cssClass"></c:set>
                </c:if>
                <tr class="${cssClass}">
                    <td>${place.id}</td>
                    <td>${place.nbSpot}</td>

                    <td>${place.plug}</td>
                    <td>${place.location}</td>
                    <td></td>
                    <td>
                        <button class="btn btn-warning" style="margin: 0px;"><a href="<c:url value='' />">Modifier</a>
                        </button>
                    </td>
                    <td>
                        <button style="margin:0px" class="btn btn-danger"><a href="<c:url value='' />">Supprimer</a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p>${id}</p>
    <br>

</div>


<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>