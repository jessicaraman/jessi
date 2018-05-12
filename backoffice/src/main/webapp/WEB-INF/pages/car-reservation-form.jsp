<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
    <h2 class="modal-title text-center" id="exampleModalLabel">Réserver un véhicule</h2>
    <%--@elvariable id="filters" type="fr.digicar.odt.FilterBookingOdt"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/reservation/carAvailable"
               modelAttribute="filters">

        <div class="row">


            <div class="col-md-3">
                <form:label path="startTime"> Heure de début</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:input type="datetime-local" path="startTime" cssClass="form-control"/>
                </div>
            </div>

            <div class="col-md-3">
                <form:label path="endTime">Heure de fin</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:input type="datetime-local" path="endTime" cssClass="form-control"/>
                </div>
            </div>

        </div>
        <div class="row">

            <div class="col-md-3">
                <%--<form:label path="arrivedCity">Ville</form:label>--%>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border"
                                 path="startCity">
                        <form:option value="" disabled="true" selected="true">Ville de départ</form:option>
                        <%--@elvariable id="setOfTown" type="java.util.Set<String>"--%>
                        <c:forEach items="${setOfTown}" var="town">
                            <form:option value="${town}">${town}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>

            <div class="col-md-3">
                    <%--<form:label path="arrivedCity">Ville</form:label>--%>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border"
                                 path="arrivedCity">
                        <form:option value="" disabled="true" selected="true">Ville d'arrivée</form:option>
                        <%--@elvariable id="setOfTown" type="java.util.Set<String>"--%>
                        <c:forEach items="${setOfTown}" var="town">
                            <form:option value="${town}">${town}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>

            <div class="col-md-3">
                <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border"
                             path="carType">
                    <form:option value="" disabled="true" selected="true">Type de véhicule</form:option>
                    <%--@elvariable id="listOfCarType" type="java.util.List<fr.digicar.model.CarType>"--%>
                    <c:forEach items="${listOfCarType}" var="cartype">
                        <form:option value="${cartype.id}">${cartype.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>


            <div class="col-md-3">

                <div class="row">
                    <div class="input-group md-form form-sm form-2 pl-0">
                        <button type="submit" class="btn btn-primary" title="Lister les véhicules disponibles"><i
                                class="fa fa-search"
                                aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>


    </form:form>


</div>

<c:choose>
    <%--@elvariable id="message" type="java.lang.String"--%>
    <c:when test="${not empty message}">
        <div class="row">
            <div class="alert alert-success w-100">${message}</div>
        </div>
        <br />
    </c:when>
    <%--@elvariable id="submitMessage" type="java.lang.String"--%>
    <c:when test="${not empty submitMessage}">
        <div class="row">
            <div class="alert alert-success w-100">${submitMessage}</div>
                <%--@elvariable id="reservationFilter" type="fr.digicar.odt.ReservationOdt"--%>
            <div class="alert alert-success w-100">
                <ul>
                    <li>Immatriculation: ${reservationFilter.registrationNumber}</li>
                    <li>Marque: ${reservationFilter.mark}</li>
                    <li>Modèle: ${reservationFilter.model}</li>
                    <li>Adresse de prise en charge: ${reservationFilter.addressParking}, ${reservationFilter.city}</li>
                    <li>Numéro de place de parking: ${reservationFilter.nbSpot}</li>
                    <li>Prix: ${reservationFilter.price}</li>
                    <li>Rappel horaires:
                        <ul>
                            <li>date de début: ${reservationFilter.startTime}</li>
                            <li>date de fin: ${reservationFilter.endTime}</li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </c:when>
</c:choose>


