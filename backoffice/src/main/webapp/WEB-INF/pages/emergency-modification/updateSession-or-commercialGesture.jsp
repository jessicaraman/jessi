<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CarSharingClub - Front Office</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.0/css/font-awesome.min.css"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<div class="header">
    <nav class="navbar navbar-expand-lg navbar-dark indigo">
        <a class="navbar-brand" href="<c:url value="/"/>">CSC Inside</a>
        <button class="navbar-toggler" type="button"
                data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Modification de session</a>
                </li>

            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <%--@elvariable id="sessionInLateId" type="java.lang.String"--%>

    <%--@elvariable id="message" type="java.lang.String"--%>
    <c:if test="${not empty message}">
        <div class="row">
            <div class="alert alert-warning w-100">${message}</div>
        </div>
    </c:if>

        <div class="row"></div>
        <%--@elvariable id="bon" type="java.lang.String"--%>
        <%--@elvariable id="commercialGesture" type="fr.digicar.odt.CommercialGestureOdt</iframe>"--%>
        <c:if test="${ empty message}">
            <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/commercialGesture/${sessionInLateId}" modelAttribute="commercialGesture">
                <div class="row" style="margin-left: 75px">
                    <div class="col-md-3">
                        <div class="input-group md-form form-sm form-2 pl-0">
                            <form:input name="bonCode" path="bonCode" type="text" value= "${bon}"/>
                            <form:label path="bonCode" >Bon de réduction</form:label>
                        </div>
                    </div>
                    <div class="col-md-1">
                        <div class="input-group md-form form-sm form-2 pl-0">
                            <form:input name="bookingIdForCommercialFGesture" path="bookingIdForCommercialFGesture" type="hidden" value= "${bookingId}"/>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-outline-blue btn-rounded btn-sm my-0" title="Enrégistrer le bon"><i class="fa fa-save" aria-hidden="true"></i></button>
                    </div>
                </div>
            </form:form>
        </c:if>
</div>

    <div class="row" style="margin-left: 200px">Ou</div>

<%--@elvariable id="chosenvehicle" type="fr.digicar.odt.ChosenvehicleOdt</iframe>"--%>
<%--@elvariable id="allCars" type="java.util.List</iframe>"--%>
<%--@elvariable id="parkingSpotList" type="java.util.List</iframe>"--%>
<%--@elvariable id="availabilityList" type="java.util.List</iframe>"--%>
<%--@elvariable id="bookingId" type="java.lang.String"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/updateSession/${sessionInLateId}" modelAttribute="chosenvehicle">
        <div class="row" style="margin-left: 75px">

            <div class="col-md-6">
                <form:label path="carId" >Liste des véhicules disponibles avec le même confort</form:label>

                    <%--@elvariable id="messageDispo" type="java.lang.String"--%>
                    <c:if test="${not empty messageDispo}">
                        <div class="row">
                            <div class="alert alert-warning w-100">${messageDispo}</div>
                        </div>
                    </c:if>

                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="carId">

                        <c:forEach items="${availabilityList}" var="availability" >

                            <c:forEach items="${allCars}" var="car">
                                <c:if test="${car.id eq availability.id_car}">
                                    <c:set var="carRegistration" value="${car.registrationNumber}" scope="request"/>
                                    <c:set var="carbrandName" value="${car.brandName}" scope="request"/>
                                    <c:set var="carModelName" value="${car.modelName}" scope="request"/>
                                    <c:set var="comfort" value="${car.comfort}" scope="request"/>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${parkingSpotList}" var="parking">
                                <c:if test="${parking.id eq availability.id_parking_spots}">
                                    <c:set var="parkingLocation" value="${parking.location}" scope="request"/>
                                </c:if>
                            </c:forEach>

                            <form:option value="${availability.id_car}" > ${carRegistration} : ${carbrandName} ${carModelName} de comfort ${comfort} dans la ville ${parkingLocation}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>

            <div class="col-md-1">
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:input name="bookingId" path="bookingId" type="hidden" value= "${bookingId}"/>
                </div>
            </div>
            <div class="col-md-2">
                <button type="submit" class="btn btn-outline-blue btn-rounded btn-sm my-0" title="Mettre à jour la session"><i class="fa fa-refresh" aria-hidden="true"></i></button>
            </div>
        </div>

    </form:form>

<%--@elvariable id="availabilityListWithoutComfort" type="java.util.List</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/updateSession/${sessionInLateId}" modelAttribute="chosenvehicle">
            <div class="row" style="margin-left: 75px">

                <div class="col-md-6">
                    <form:label path="carId" >Liste des véhicules disponibles avec un confort proche</form:label>

                        <%--@elvariable id="messageDispo" type="java.lang.String"--%>
                        <c:if test="${not empty messageDispo}">
                            <div class="row">
                                <div class="alert alert-warning w-100">${messageDispo}</div>
                            </div>
                        </c:if>

                    <div class="input-group md-form form-sm form-2 pl-0">
                        <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="carId">

                            <c:forEach items="${availabilityListWithoutComfort}" var="availability" >

                                <c:forEach items="${allCars}" var="car">
                                    <c:if test="${car.id eq availability.id_car}">
                                        <c:set var="carRegistration" value="${car.registrationNumber}" scope="request"/>
                                        <c:set var="carbrandName" value="${car.brandName}" scope="request"/>
                                        <c:set var="carModelName" value="${car.modelName}" scope="request"/>
                                        <c:set var="comfort" value="${car.comfort}" scope="request"/>
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${parkingSpotList}" var="parking">
                                    <c:if test="${parking.id eq availability.id_parking_spots}">
                                        <c:set var="parkingLocation" value="${parking.location}" scope="request"/>
                                    </c:if>
                                </c:forEach>

                                <form:option value="${availability.id_car}" > ${carRegistration} : ${carbrandName} ${carModelName} de comfort ${comfort} dans la ville ${parkingLocation}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <div class="col-md-1">
                    <div class="input-group md-form form-sm form-2 pl-0">
                        <form:input name="bookingId" path="bookingId" type="hidden" value= "${bookingId}"/>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-outline-blue btn-rounded btn-sm my-0" title="Mettre à jour la session"><i class="fa fa-refresh" aria-hidden="true"></i></button>
                </div>
            </div>

        </form:form>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>