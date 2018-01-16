<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>CSC - BackOffice</title>
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/mdb.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"/>
</head>
<body>

<%--@elvariable id="message" type="java.lang.String"--%>
<c:if test="${not empty message}">
    <div class="row">
        <div class="alert alert-danger w-100">${message}</div>
    </div>
</c:if>

<div class="container">
    <%--@elvariable id="filteregistration" type="fr.digicar.odt.FilterRegistrationIdOdt</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/car/registrationId" modelAttribute="filteregistration">
        <div class="row">
                <div class="col-md-3">
                    <div class="input-group md-form form-sm form-2 pl-0">
                        <form:input name="registrationNumber" path="registrationNumber" minlength="" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                        <form:label path="registrationNumber" data-error="Immatriculation invalide">Immatriculation</form:label>
                    </div>
                </div>
                <div class="col-md-2">
                    <input type="submit" class="btn btn-primary text-right">search</input>
                </div>
        </div>
    </form:form>

<%--@elvariable id="filters" type="fr.digicar.odt.FilterOdt"</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/car/allcars" modelAttribute="filters">
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="carBrand" id="form-autocomplete" required="required" cssClass="form-control my-0 py-1 grey-border mdb-autocomplete" type="search"/>
                <form:label for="form-autocomplete" cssClass="active" path="carBrand" data-error="marque invalide">Marque</form:label>
            </div>
        </div>

        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="modelName" required="required" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="modelName" data-error="modèle invalide">Modèle</form:label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="mileageMin" cssClass="form-control my-0 py-1 grey-border" type="number"/>
                <form:label path="mileageMin">Kilometrage Min</form:label>
            </div>
        </div>
        <div>
            <span>A</span>
        </div>
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="mileageMax" cssClass="form-control my-0 py-1 grey-border" type="number"/>
                <form:label path="mileageMax">Kilometrage Max</form:label>
            </div>
        </div>
        <div class="col-md-3">
            <form:label path="typeCar" >Type de véhicule</form:label>
            <form:select path="typeCar" cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border">
                    <form:option value="" disabled="true" selected="true">Choose your option</form:option>
                    <form:option value="1">citadine</form:option>
                    <form:option value="2">berline</form:option>
                    <form:option value="3">...</form:option>
                </form:select>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="transmission" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="transmission">Type de transmission</form:label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="fuelType" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="fuelType">Type de carburant</form:label>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="numberOfDoor" minlength="1" cssClass="form-control my-0 py-1 grey-border" type="number"/>
                <form:label path="numberOfDoor">Nombre de portes</form:label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input path="numberOfSeats" minlength="1" cssClass="form-control my-0 py-1 grey-border" type="number"/>
                <form:label path="numberOfSeats">Nombre de places</form:label>
            </div>
        </div>
    </div>
    <div class="row">
        <span>...</span>
    </div>
    <div class="modal-footer">
        <button type="submit" class="btn btn-primary">rechercher</button>
    </div>
    </form:form>

</div>


<script type="text/javascript">
    // Material Select Initialization
    $(document).ready(function() {
        $('.mdb-select').material_select();
    });
    var mark = [
        "MAZDA",
        "TOYOTA",
        "CLIOT",
        "PEUGEOT",
        "RENAULT"
    ];

    $('.mdb-autocomplete').mdb_autocomplete({
        data: mark
    });
</script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>

</body>
</html>