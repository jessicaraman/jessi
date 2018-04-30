<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Liste des véhicules</h3>

    <div class="table">
        <%--@elvariable id="cars" type="java.util.List"--%>
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
                    <%--@elvariable id="cars" type="java.util.List"--%>
                    <%--@elvariable id="car" type="fr.digicar.model.Car"--%>
                <c:forEach items="${cars}" var="car">
                    <%--@elvariable id="listOfTransmissionMode" type="java.util.List"--%>
                    <c:forEach items="${listOfTransmissionMode}" var="transmissiontype">
                        <c:if test="${transmissiontype.id eq car.transmission}">
                            <c:set var="transmissionType" value="${transmissiontype.name}" scope="request"/>
                        </c:if>
                    </c:forEach>
                    <%--@elvariable id="listOfCarType" type="java.util.List"--%>
                    <c:forEach items="${listOfCarType}" var="cartype">
                        <c:if test="${cartype.id eq car.type}">
                            <c:set var="typeCar" value="${cartype.name}" scope="request"/>
                        </c:if>
                    </c:forEach>
                    <%--@elvariable id="listOfFuelType" type="java.util.List"--%>
                    <c:forEach items="${listOfFuelType}" var="fueltype">
                        <c:if test="${fueltype.id eq car.fuelType}">
                            <c:set var="fuelType" value="${fueltype.name}" scope="request"/>
                        </c:if>
                    </c:forEach>

                    <tr>
                        <td>${car.registrationNumber}</td>
                        <td>${car.brandName}</td>
                        <td>${car.modelName}</td>
                        <td>${transmissionType}</td>
                        <td>${car.seatNumber}</td>
                        <td>${car.doorNumber}</td>
                        <td>${typeCar}</td>
                        <td>${car.kilometers}</td>
                        <td>${car.releaseDate}</td>
                        <td>${car.comfort}</td>
                        <td>${fuelType}</td>
                        <td>
                            <button class="btn btn-warning m-0" title="Modifier">
                                <a href="<c:url value="updateCar/${car.id}" />">
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </a>
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-danger m-0" title="Supprimer ">
                                <a href="<c:url value="deleteCar/${car.registrationNumber}/${car.id}" />">
                                    <i class="fa fa-trash-o" aria-hidden="true"></i>
                                </a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>