<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">
    <h2 class="modal-title text-center" id="exampleModalLabel">Réserver un véhicule</h2>
    <%--@elvariable id="filters" type="fr.digicar.odt.FilterReservationOdt</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/reservation/findAvailableByCreteria"
               modelAttribute="filters">

        <div class="row">
            <div class="col-md-3">
                <form:label  path="wishedDate">Date</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:input type="date" path="wishedDate" cssClass="form-control"/>
                </div>
            </div>

            <div class="col-md-3">
                <form:label path="start_time" > Heure de début</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <input type="time" path="start_time" cssClass="form-control"/>
                </div>
            </div>

            <div class="col-md-3">
                <form:label path="end_time" >Heure de début</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <input type="time" path="end_time" cssClass="form-control"/>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-md-3">
                <form:label path="postal_code">Transmission</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:select path="postal_code" cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border">
                        <form:option value="" disabled="true" selected="true">Choisir le departement</form:option>
                        <c:forEach items="${listOfTown}" var="town">
                            <form:option value="${town.location}">${town.location}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>


        </div>
        <div class="col-md-3">
            <div class="text-left">
                <button type="submit" class="btn btn-primary" title="Lister les véhicules disponibles"><i
                        class="fa fa-search"
                        aria-hidden="true"></i>
                </button>
            </div>
        </div>

    </form:form>


</div>

<%--@elvariable id="message" type="java.lang.String"--%>
<c:if test="${not empty message}">
    <div class="row">
        <div class="alert alert-success w-100">${message}</div>
    </div>
</c:if>


