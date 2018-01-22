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
        <div class="row"></div>
<%--@elvariable id="filteregistration" type="fr.digicar.odt.FilterRegistrationIdOdt</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/car/registrationId" modelAttribute="filteregistration">
        <div class="row">
                <div class="col-md-3">
                    <div class="input-group md-form form-sm form-2 pl-0">
                        <form:input title="AA-OO1-AA" maxlength="7" onKeypress="if((event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 65 || event.keyCode > 90) && (event.keyCode < 97 || event.keyCode > 122)) event.returnValue = false;if((event.which < 48 || event.which > 57) && (event.which < 65 || event.which > 90) && (event.which < 97 || event.which > 122)) return false;"
                                    cssStyle="text-transform:uppercase" name="registrationNumber" path="registrationNumber" minlength="" required="required" cssClass="form-control validate my-0 py-1 grey-border" type="text"/>
                        <form:label path="registrationNumber" data-error="Immatriculation invalide">Immatriculation</form:label>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-outline-blue btn-rounded btn-sm my-0">Search</button>
                </div>
        </div>

    </form:form>
    </div>
<div class="container">


<%--@elvariable id="filters" type="fr.digicar.odt.FilterOdt"</iframe>"--%>
    <form:form method="POST" action="${pageContext.request.contextPath}/car/allcars" modelAttribute="filters">
    <div class="row">
        <div class="col-md-3">
            <form:label for="form-autocomplete" cssClass="active" path="carBrand" data-error="marque invalide">Marque</form:label>
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:select cssClass="form-control validate rounded validate mdb-select  my-0 py-1 grey-border" path="carBrand">
                    <form:option value="" disabled="true" selected="">Choisir une marque</form:option>
                    <form:option value="1" >Cliot</form:option>
                    <form:option value="2" >Peugeot</form:option>
                    <form:option value="3" >Renault</form:option>
                    <form:option value="4" >...</form:option>
                </form:select>
            </div>
        </div>

        <div class="col-md-3">
            <form:label path="modelName" >Modèle</form:label>
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="modelName">
                    <form:option value="" disabled="true" selected="">Choisir un modèle</form:option>
                        <form:option value="1" >Cliot2</form:option>
                        <form:option value="2" >Peugeot 207</form:option>
                        <form:option value="3" >Mazda 3</form:option>
                        <form:option value="4" >...</form:option>
                </form:select>
            </div>
        </div>
        <div class="col-md-3">
            <form:label path="typeCar" >Type de véhicule</form:label>
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="typeCar">
                    <form:option value="" disabled="true" selected="">Choisir un type</form:option>
                    <c:forEach items="${listOfCarType}" var="carType" >
                        <form:option value="${carType.id}" >${carType.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input value="" onKeypress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;if(event.which < 48 || event.which > 57) return false;"
                            maxlength="6" path="mileageMin" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="mileageMin">Kilometrage Min</form:label>
            </div>
        </div>

        <span>A</span>

        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input value="" onKeypress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;if(event.which < 48 || event.which > 57) return false;"
                            maxlength="6" path="mileageMax" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="mileageMax">Kilometrage Max</form:label>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <form:label path="transmission" >Transmission</form:label>
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="transmission">
                    <form:option value="" disabled="true" selected="">Choisir la transmission</form:option>
                    <c:forEach items="${listOfTransmissionMode}" var="transmissionMode" >
                        <form:option value="${transmissionMode.id}" >${transmissionMode.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>
        <div class="col-md-3">
            <form:label path="fuelType" >Carburant</form:label>
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:select cssClass="form-control rounded validate mdb-select  my-0 py-1 grey-border" path="fuelType">
                    <form:option value="" disabled="true" selected="">Choisir le carburant</form:option>
                    <c:forEach items="${listOfFuelType}" var="fuelType" >
                        <form:option value="${fuelType.id}" >${fuelType.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input value="" onKeypress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;if(event.which < 48 || event.which > 57) return false;"
                            path="numberOfDoor" maxlength="1" cssClass="form-control my-0 py-1 grey-border" type="text"/>
                <form:label path="numberOfDoor">Nombre de portes</form:label>
            </div>
        </div>
        <div class="col-md-3">
            <div class="input-group md-form form-sm form-2 pl-0">
                <form:input value="" onKeypress="if(event.keyCode < 48 || event.keyCode > 57) event.returnValue = false;if(event.which < 48 || event.which > 57) return false;"
                            path="numberOfSeats" maxlength="1" cssClass="form-control my-0 py-1 grey-border" type="text"/>
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