<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>CarSharingClub - BackOffice</title>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
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

            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/modifurgent/"/>">Actualiser</a>
            </li>

            <h3>Liste des sessions en retard</h3>

            <%--@elvariable id="calculatedDelay" type="java.util.List"--%>
            <c:if test="${!empty calculatedDelay}">
                <table class="table table-hover">
                    <tr>
                        <th width="80">Id du retard</th>
                        <th width="120">registrationNumber</th>
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
                    <c:forEach items="${calculatedDelay}" var="place">
                        <%--@elvariable id="place" type="fr.digicar.model.CalculatedDelay"--%>
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
                                <%--@elvariable id="ligneRetard" type="fr.digicar.model.CalculatedDelay"--%>
                                <form:form method="GET" modelAttribute="ligneRetard" action="/modifurgent/cloturer/${place.id}">
                                    <button type="submit" class="btn btn-danger m-0">
                                        Clôturer
                                    </button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <br/>

            <h3>Liste des sessions en retard déjà appelées</h3>

            <%--@elvariable id="retardCalculeAppeler" type="java.util.List"--%>
            <c:if test="${!empty retardCalculeAppeler}">
                <table class="table table-hover">
                    <tr>
                        <th width="80">Id du retard</th>
                        <th width="120">registrationNumber</th>
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
                        <%--@elvariable id="place" type="fr.digicar.model.CalculatedDelay"--%>
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
                                <%--@elvariable id="ligneRetard" type="fr.digicar.model.CalculatedDelay"--%>
                                <form:form method="GET" modelAttribute="ligneRetard" action="/modifurgent/reouvrir/${place.id}">
                                    <button type="submit" class="btn btn-danger m-0">Relancer
                                    </button>
                                </form:form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <br/>

            <h3>Liste des sessions en cours Non en retard</h3>

            <%--@elvariable id="retardCalculeNonEnRetard" type="java.util.List"--%>
            <c:if test="${!empty retardCalculeNonEnRetard}">
                <table class="table table-hover">
                    <tr>
                        <th width="80">Id du retard</th>
                        <th width="120">registrationNumber</th>
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
                        <%--@elvariable id="place" type="fr.digicar.model.CalculatedDelay"--%>
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
            <br/>
        </div>

        <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
    </body>
</html>