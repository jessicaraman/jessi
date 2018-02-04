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
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Véhicules</a>
                            <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="<c:url value="/car/"/>">Liste véhicule</a>
                                <a class="dropdown-item" href="">Ajouter</a>
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

        <div>

        </div>
        <c:if test="${!empty addedCar}">
            <table class="table">
                <tbody>
                <tr>
                    <td>Immatriculation</td>
                    <td>${addedCar.registration_number}</td>
                </tr>
                <tr>
                    <td>Marque</td>
                    <td>${addedCar.mark}</td>
                </tr>
                <tr>
                    <td>Nom du modèle</td>
                    <td>${addedCar.name_model}</td>
                </tr>
                <tr>
                    <td>Mode de transmission</td>
                    <td>${addedCar.transmission}</td>
                </tr>
                <tr>
                    <td>Nombre de places</td>
                    <td>${addedCar.nb_places}</td>
                </tr>
                <tr>
                    <td>Nombre de portes</td>
                    <td>${addedCar.nb_doors}</td>
                </tr>
                <tr>
                    <td>Type de véhiclue</td>
                    <td>${addedCar.type}</td>
                </tr>
                <tr>
                    <td>Emplacement</td>
                    <td>${addedCar.location}</td>
                </tr>
                <tr>
                    <td>Date de mise en circulation</td>
                    <td>${addedCar.release_date}</td>
                </tr>
                <tr>
                    <td>Confort</td>
                    <td>${addedCar.comfort}</td>
                </tr>
                <tr>
                    <td>Type de véhiclue</td>
                    <td>${addedCar.type}</td>
                </tr>
                <tr>
                    <td>Type de carburant</td>
                    <td>${addedCar.fuel_type}</td>
                </tr>
                </tbody>
            </table>
        </c:if>

    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
    </body>
</html>