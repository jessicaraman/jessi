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

    <div class="row"></div>
    <%--@elvariable id="bonreduction" type="java.lang.String"--%>
        <%--@elvariable id="commercialGesture" type="fr.digicar.odt.commercialGestureOdt</iframe>"--%>
        <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/commercialGesture" modelAttribute="commercialGesture">
            <div class="row" style="margin-left: 75px">
                <div class="col-md-3">
                    <div class="input-group md-form form-sm form-2 pl-0">
                        <form:input name="bonreduction" path="bonreduction" type="text" value= "${bonreduction}" disabled="true" readonly="readonly"/>
                        <form:label path="bonreduction">Bon de réduction</form:label>
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
    </div>

    <div class="row" style="margin-left: 200px">Ou</div>
<%--@elvariable id="chosenvehicle" type="fr.digicar.odt.ChosenvehicleOdt</iframe>"--%>
<%--@elvariable id="bookingId" type="java.lang.String"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/updateSession" modelAttribute="chosenvehicle">
        <div class="row" style="margin-left: 75px">

            <div class="col-md-3">
                <form:label path="carId" >Liste des véhicules disponibles à proximité</form:label>
                <div class="input-group md-form form-sm form-2 pl-0">
                    <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="carId">

                        <%--@elvariable id="listOfCarforChoose" type="java.util.List"--%>
                        <c:forEach items="${listOfCarforChoose}" var="car" >
                            <form:option value="${car.id}" > ${car.brandName} ${car.modelName} ${car.comfort} </form:option>
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
</div>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>