<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Liste des véhicules disponibles</h3>

    <c:if test="${!empty cars}">
        <div class="table">
            <table class="table table-hover">
                <tr>
                    <th width="80">Immatriculation</th>
                    <th width="120">Marque</th>
                    <th width="120">Nom du modèle</th>
                </tr>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.registration_number}</td>
                        <td>${car.mark}</td>
                        <td>${car.name_model}</td>
                        <td><button class="btn btn-primary" style="margin: 0px;" title="réserver"><a href="<c:url value="" />" ><i class="fa fa-pencil" aria-hidden="true"></i></a></button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>