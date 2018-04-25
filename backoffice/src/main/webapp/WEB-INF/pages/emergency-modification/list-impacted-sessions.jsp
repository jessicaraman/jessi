<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Réservations impactées</h3>


    <div class="table">
        <c:if test="${!empty bookingimpacted}">
            <table class="table table-hover">
                <tr>
                    <th width="80">Immatriculation</th>
                    <th width="120">Marque</th>
                    <th width="120">Nom du modèle</th>
                </tr>
                <c:forEach items="${bookingimpacted}" var="booking">

                    <tr>
                        <td>${booking.registration_number}</td>
                        <td>${booking.mark}</td>
                        <td>${booking.name_model}</td>
                        <td><button class="btn btn-warning" style="margin: 0px;" title="Modifier"><a href="<c:url value="edditingImpactedSession/${booking.id}" />" ><i class="fa fa-pencil" aria-hidden="true"></i></a></button></td>
                        <td><button style="margin:0px" class="btn btn-danger" title="Annuler "><a href="<c:url value="cancel/${booking.id}" />" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>