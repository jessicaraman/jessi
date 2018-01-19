<%--
  Created by IntelliJ IDEA.
  User: barry
  Date: 15/01/2018
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
<h3 class="text-center">Liste des véhicules</h3>

<div class="table">
    <c:if test="${!empty cars}">
        <table class="table table-hover">
            <tr>
                <th width="80">Immatriculation</th>
                <th width="120">Marque</th>
                <th width="120">Nom du modèle</th>
                <th width="60">Type de transmission</th>
                <th width="60">Nombre de places</th>
                <th width="100">Nombre de portes</th>
                <th width="100">Type de véhicule</th>
                <th width="100">Emplacement</th>
                <th width="10">Kilométrage</th>
                <th width="60">Date de mise en circulation</th>
                <th width="10">Confort</th>
                <th width="50">Type de carburant</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.registration_number}</td>
                    <td>${car.mark}</td>
                    <td>${car.name_model}</td>
                    <td>${car.transmission}</td>
                    <td>${car.nb_places}</td>
                    <td>${car.nb_doors}</td>
                    <td>${car.type}</td>
                    <td>${car.location}</td>
                    <td>${car.kilometers}</td>
                    <td>${car.release_date}</td>
                    <td>${car.comfort}</td>
                    <td>${car.fuel_type}</td>
                    <td><button class="btn btn-warning" style="margin: 0px;"><a href="<c:url value="car/updateCar/${car.registration_number}" />" >Modifier</a></button></td>
                    <td><button style="margin:0px" class="btn btn-danger"><a href="<c:url value="car/deleteCar/${car.registration_number}" />" >Supprimer</a></button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</div>