<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container">
    <h3 class="text-center">Réservations impactées</h3>

    <div class="table">
        <c:if test="${!empty bookingImpacted}">
            <table class="table table-hover">
                <tr>
                    <th width="80">Immatriculation</th>
                    <th width="120">Départ</th>
                    <th width="120">Arrivé</th>
                    <th width="120">Id_user</th>
                    <th width="120">Place_départ</th>
                    <th width="120">Place_arrivée</th>
                    <th width="120">Numéro</th>
                </tr>

                    <%--@elvariable id="sessionInLateId" type="java.lang.String"--%>

                <c:forEach items="${bookingImpacted}" var="booking">

                    <%--@elvariable id="AllUser" type="java.util.List"--%>
                    <c:forEach items="${AllUser}" var="user">
                        <c:if test="${booking.id_user eq user.id}">
                            <c:set var="userPhoneNumber" value="${user.phoneNumber}" scope="request"/>
                        </c:if>
                    </c:forEach>
                    <tr>
                        <td>${booking.car_registration_id}</td>
                        <td>${booking.departure_date}</td>
                        <td>${booking.arrival_date}</td>
                        <td>${booking.id_user}</td>
                        <td>${booking.idPlaceDepart}</td>
                        <td>${booking.idPlaceArrivee}</td>
                        <td>${userPhoneNumber}</td>
                        <td><button class="btn btn-warning" style="margin: 0px;" title="Modifier"><a href="<c:url value="edditingImpactedSession/${booking.id}/${sessionInLateId}" />" ><i class="fa fa-pencil" aria-hidden="true"></i></a></button></td>
                        <td><button style="margin:0px" class="btn btn-danger" title="Annuler "><a href="<c:url value="cancel/${booking.id}" />" ><i class="fa fa-trash-o" aria-hidden="true"></i></a></button></td>

                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>