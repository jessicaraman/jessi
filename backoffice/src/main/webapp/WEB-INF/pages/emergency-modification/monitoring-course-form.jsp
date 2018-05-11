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
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Modification de session</a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<c:url value="/modifurgent/impactedSession"/>">sessions impactées</a>
                    <a class="dropdown-item" href="<c:url value="/modifurgent/usersPreferencesView"/>">préférences utilisateurs</a>
                    <a class="dropdown-item" href="<c:url value="/modifurgent/commercialGestureView"/>">Gestes commerciaux</a>
                    <a class="dropdown-item">Liste retards</a>
                    <a class="dropdown-item" href="<c:url value="/modifurgent/bookingList"/>">Liste des réservations</a>
                </div>
            </li>

        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        </form>
    </div>
</nav>
<!--/.Navbar-->

<div class="container">

    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/modifurgent/"/>">Actualiser</a>
    </li>

    <h3>Liste des sessions en retard</h3>

    <c:if test="${!empty retardCalcule}">
        <table class="table table-hover">
            <tr>
                <th width="80">Id du retard</th>
                <th width="120">Immatriculation</th>
                <th width="30">Marque</th>
                <th width="60">Modèle</th>
                <th width="100">Heure prévue du retour</th>
                <th width="30">Heure calculée du retour</th>
                <th width="30">Penalité</th>
                <th width="30">Nom</th>
                <th width="30">Prénom</th>
                <th width="30">Téléphone</th>
                <th width="10">Tag</th>
                <th width="30">Id de la session</th>

            </tr>
            <c:forEach items="${retardCalcule}" var="place">
                <c:if test="${!empty id} && ${place.id}==${id}">
                    <c:set value="table-success" var="cssClass"></c:set>
                </c:if>

                <tr class="${cssClass}">
                    <td>${place.id}</td>
                    <td>${place.registrationNumber}</td>
                    <td>${place.brand}</td>
                    <td>${place.model}</td>
                    <td>${place.expectedReturnTime}</td>
                    <td>${place.calculatedReturnTime}</td>
                    <td>${place.penality}</td>
                    <td>${place.firstName}</td>
                    <td>${place.lastName}</td>
                    <td>${place.phoneNumber}</td>
                    <td>${place.tagAppel}</td>
                    <td>${place.idSession}</td>
                    <td>
                        <form:form method="GET" modelAttribute="ligneRetard" action="/modifurgent/cloturer/${place.id}">
                        <button style="margin:0px" type="submit" class="btn btn-danger">Cloturer
                        </button>
                        </form:form>
                    </td>
                    <td><button class="btn btn-warning" style="margin: 0px;" title="Voir conflits"><a href="<c:url value="/modifurgent/impactedSession/${place.registrationNumber}" />" ><i class="fa fa-eye" aria-hidden="true"></i></a></button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br>
    <h3>Liste des sessions en retard déjà appelées</h3>

    <c:if test="${!empty retardCalculeAppeler}">
        <table class="table table-hover">
            <tr>
                <th width="80">Id du retard</th>
                <th width="120">Immatriculation</th>
                <th width="30">Marque</th>
                <th width="60">Modèle</th>
                <th width="100">Heure prévue du retour</th>
                <th width="30">Heure calculée du retour</th>
                <th width="30">Penalité</th>
                <th width="30">Nom</th>
                <th width="30">Prénom</th>
                <th width="30">Téléphone</th>
                <th width="10">Tag</th>
                <th width="30">Id de la session</th>

            </tr>
            <c:forEach items="${retardCalculeAppeler}" var="place">
                <c:if test="${!empty id} && ${place.id}==${id}">
                    <c:set value="table-success" var="cssClass"></c:set>
                </c:if>

                <tr class="${cssClass}">
                    <td>${place.id}</td>
                    <td>${place.registrationNumber}</td>
                    <td>${place.brand}</td>
                    <td>${place.model}</td>
                    <td>${place.expectedReturnTime}</td>
                    <td>${place.calculatedReturnTime}</td>
                    <td>${place.penality}</td>
                    <td>${place.firstName}</td>
                    <td>${place.lastName}</td>
                    <td>${place.phoneNumber}</td>
                    <td>${place.tagAppel}</td>
                    <td>${place.idSession}</td>
                    <td>
                        <form:form method="GET" modelAttribute="ligneRetard" action="/modifurgent/reouvrir/${place.id}">
                            <button style="margin:0px" type="submit" class="btn btn-danger">Relancer
                            </button>
                        </form:form>
                    </td>
                    <td><button class="btn btn-warning" style="margin: 0px;" title="Voir conflits"><a href="<c:url value="/modifurgent/impactedSession/${place.registrationNumber}" />" ><i class="fa fa-eye" aria-hidden="true"></i></a></button></td>


                </tr>

            </c:forEach>
        </table>
    </c:if>

    <br>

    <h3>Liste des sessions en cours Non en retard</h3>

    <c:if test="${!empty retardCalculeNonEnRetard}">
        <table class="table table-hover">
            <tr>
                <th width="80">Id du retard</th>
                <th width="120">Immatriculation</th>
                <th width="30">Marque</th>
                <th width="60">Modèle</th>
                <th width="100">Heure prévue du retour</th>
                <th width="30">Heure calculée du retour</th>
                <th width="30">Penalité</th>
                <th width="30">Nom</th>
                <th width="30">Prénom</th>
                <th width="30">Téléphone</th>
                <th width="10">Tag</th>
                <th width="30">Id de la session</th>

            </tr>
            <c:forEach items="${retardCalculeNonEnRetard}" var="place">
                <c:if test="${!empty id} && ${place.id}==${id}">
                    <c:set value="table-success" var="cssClass"></c:set>
                </c:if>

                <tr class="${cssClass}">
                    <td>${place.id}</td>
                    <td>${place.registrationNumber}</td>
                    <td>${place.brand}</td>
                    <td>${place.model}</td>
                    <td>${place.expectedReturnTime}</td>
                    <td>${place.calculatedReturnTime}</td>
                    <td>${place.penality}</td>
                    <td>${place.firstName}</td>
                    <td>${place.lastName}</td>
                    <td>${place.phoneNumber}</td>
                    <td>${place.tagAppel}</td>
                    <td>${place.idSession}</td>

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