<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>S'enregistrer - CarSharingClub</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark elegant-color-dark">
        <div class="container">
            <a class="navbar-brand" href="<c:url value="/"/>">CarSharingClub</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Features</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Pricing</a>
                    </li>
                </ul>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                </form>
            </div>
        </div>
    </nav>
</header>

<div class="container">
    <a class="navbar-brand" href="<c:url value="/"/>">CarSharingClub</a>
    <h5 class="modal-title text-center" id="exampleModalLabel">Réserver un véhicule</h5>
    <%--@elvariable id="filters" type="fr.digicar.odt.FilterRegistrationIdOdt</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/findAvailableByCreteria"
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
                    <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border"
                                 path="transmission">
                        <form:option value="" disabled="true" selected="true">Choisir le departement</form:option>
                        <c:forEach items="${listOfTown}" var="town">
                            <form:option value="${town.location}">${town.location}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>


        </div>
        <div class="row">
            <div class="text-left">
                <button type="submit" class="btn btn-primary" title="Lister les véhicules disponibles"><i
                        class="fa fa-search"
                        aria-hidden="true"></i>
                </button>
            </div>
        </div>

    </form:form>


</div>
<%--

&lt;%&ndash;@elvariable id="confirmationMessage" type="java.lang.String"&ndash;%&gt;
<c:if test="${not empty confirmationMessage}">
    <div class="row">
        <div class="alert alert-success w-100">${confirmationMessage}</div>
    </div>
</c:if>

<%@include file="/WEB-INF/pages/list-car.jsp"%>
--%>

<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
</body>
</html>