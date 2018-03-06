<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
                <th width="10">Kilométrage</th>
                <th width="60">Date de mise en circulation</th>
                <th width="10">Confort</th>
                <th width="50">Type de carburant</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <c:forEach items="${listOfTransmissionMode}" var="transmissiontype" >
                    <c:if test="${transmissiontype.id eq car.transmission}">
                        <c:set var="transmissionType" value="${transmissiontype.name}" scope="request" />
                    </c:if>
                </c:forEach>
                <c:forEach items="${listOfCarType}" var="cartype" >
                    <c:if test="${cartype.id eq car.type}">
                        <c:set var="typeCar" value="${cartype.name}" scope="request" />
                    </c:if>
                </c:forEach>
                <c:forEach items="${listOfFuelType}" var="fueltype" >
                    <c:if test="${fueltype.id eq car.fuel_type}">
                        <c:set var="fuelType" value="${fueltype.name}" scope="request" />
                    </c:if>
                </c:forEach>

                <tr>
                    <td>${car.registration_number}</td>
                    <td>${car.mark}</td>
                    <td>${car.name_model}</td>
                    <td>${transmissionType}</td>
                    <td>${car.nb_places}</td>
                    <td>${car.nb_doors}</td>
                    <td>${typeCar}</td>
                    <td>${car.kilometers}</td>
                    <td>${car.release_date}</td>
                    <td>${car.comfort}</td>
                    <td>${fuelType}</td>
                    <td><button class="btn btn-warning" style="margin: 0px;" title="Modifier"><a href="<c:url value="updateCar/${car.id}" />" ><i class="fa fa-pencil" aria-hidden="true"></i></a></button></td>
                    <td><button style="margin:0px" class="btn btn-danger" title="Supprimer "><a href="<c:url value="deleteCar/${car.registration_number}/${car.id}" />" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</div>