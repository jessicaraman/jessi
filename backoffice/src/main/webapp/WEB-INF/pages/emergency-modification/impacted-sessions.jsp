<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>CarSharingClub - BackOffice</title>
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
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Modification de session</a>
                            <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="<c:url value="/modifurgent/impactedSession/"/>">sessions impactées</a>
                                <a class="dropdown-item" href="<c:url value="/modifurgent/"/>">Liste retards</a>
                                <a class="dropdown-item" href="<c:url value="/modifurgent/usersPreferencesView"/>">préférences utilisateurs</a>
                                <a class="dropdown-item" href="<c:url value="/modifurgent/commercialGestureView"/>">Gestes commerciaux</a>
                            </div>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
        <div class="container">
            <div class="row"></div>
            <%--@elvariable id="filteregistration" type="fr.digicar.odt.FilterRegistrationIdOdt</iframe>"--%>
            <form:form method="POST" action="${pageContext.request.contextPath}/modifurgent/impactedSession/registrationId" modelAttribute="filteregistration">
                <div class="row">
                    <div class="col-md-3">
                        <div class="input-group md-form form-sm form-2 pl-0">
                            <form:input title="AA-OO1-AA" maxlength="9" onKeypress="if( (event.keyCode !== 45) && (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 65 || event.keyCode > 90) && (event.keyCode < 97 || event.keyCode > 122)) event.returnValue = false;if( (event.which !== 45) && (event.which < 48 || event.which > 57) && (event.which < 65 || event.which > 90) && (event.which < 97 || event.which > 122)) return false;"
                                        cssStyle="text-transform:uppercase" name="registrationNumber" path="registrationNumber" minlength="" required="required" cssClass="form-control validate my-0 py-1 grey-border" type="text"/>
                            <form:label path="registrationNumber" data-error="Immatriculation invalide">Immatriculation</form:label>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-outline-blue btn-rounded btn-sm my-0" title="rechercher"><i class="fa fa-search" aria-hidden="true"></i></button>
                    </div>
                </div>

            </form:form>
        </div>
        <%@include file="list-impacted-sessions.jsp"%>

        <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
    </body>
</html>