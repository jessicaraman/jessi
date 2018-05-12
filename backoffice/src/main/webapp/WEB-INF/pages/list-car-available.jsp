<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Liste des véhicules disponibles</h3>

    <%--@elvariable id="reservations" type="java.util.List"--%>
    <c:if test="${!empty reservations}">
        <div class="table">
            <table class="table table-hover">
                <tr>
                    <th width="120">Immatriculation</th>
                    <th width="120">Marque</th>
                    <th width="120">Nom du modèle</th>
                    <th width="120">Nombre de portes</th>
                    <th width="120">Adresse du Parking</th>
                    <th width="120">Prix</th>
                </tr>
                    <%--@elvariable id="reservation" type="fr.digicar.odt.ReservationOdt"--%>
                <c:forEach items="${reservations}" var="reservation">
                    <tr>
                        <td>${reservation.registrationNumber}</td>
                        <td>${reservation.mark}</td>
                        <td>${reservation.model}</td>
                        <td>${reservation.nbDoors}</td>
                        <td>${reservation.addressParking}</td>
                        <td>${reservation.price} €</td>
                        <td>
                            <%--@elvariable id="reservationFilter" type="fr.digicar.odt.ReservationOdt"--%>
                            <form:form method="POST" modelAttribute="reservationFilter" action="/reservation/submitBooking">
                                <button type="submit" class="btn btn-primary">
                                    Réserver
                                </button>
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
</div>

<%--@elvariable id="message" type="java.lang.String"--%>
<%--<c:if test="${not empty message}">--%>
    <%--<div class="row">--%>
        <%--<div class="alert alert-success w-100">${message}</div>--%>
            <%--&lt;%&ndash;@elvariable id="reservationFilter" type="fr.digicar.odt.ReservationOdt"&ndash;%&gt;--%>
        <%--<div class="alert alert-success w-100">--%>
            <%--<ul>--%>
                <%--<li>Immatriculation: ${reservationFilter.registrationNumber}</li>--%>
                <%--<li>Marque: ${reservationFilter.mark}</li>--%>
                <%--<li>Modèle: ${reservationFilter.model}</li>--%>
                <%--<li>Adresse de prise en charge: ${reservationFilter.addressParking}, ${reservationFilter.city}</li>--%>
                <%--<li>Numéro de place de parking: ${reservationFilter.nbSpot}</li>--%>
                <%--<li>Prix: ${reservationFilter.price}</li>--%>
                <%--<li>Rappel horaires:--%>
                    <%--<ul>--%>
                        <%--<li>date de début: ${reservationFilter.startTime}</li>--%>
                        <%--<li>date de fin: ${reservationFilter.endTime}</li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${empty message}">--%>
    <%--<div class="row">--%>
        <%--<div class="alert alert-success w-100">Aucun véhicule trouvé pour cette recherche</div>--%>
            <%--&lt;%&ndash;@elvariable id="reservationFilter" type="fr.digicar.odt.ReservationOdt"&ndash;%&gt;--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</c:if>--%>

