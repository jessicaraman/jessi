<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Liste des véhicules disponibles</h3>

    <%--@elvariable id="cars" type="java.util.List"--%>
    <c:if test="${!empty cars}">
        <div class="table">
            <table class="table table-hover">
                <tr>
                    <th width="120">Marque</th>
                    <th width="120">Nom du modèle</th>
                    <th width="120">Type de véhicule</th>
                    <th width="120">Transmission</th>
                    <th width="120">Nombre de portes</th>
                </tr>
                <%--@elvariable id="car" type="fr.digicar.model.Car"--%>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.brandName}</td>
                        <td>${car.modelName}</td>
                        <td>${car.type}</td>
                        <td>${car.transmission}</td>
                        <td>${car.doorNumber}</td>
                        <td>
                            <button class="btn btn-primary m-0" title="Réserver">
                                <a href="<c:url value="" />">
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </a>
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>