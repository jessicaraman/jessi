<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Maintain vehicle referential<span class="sr-only">(current)</span></a>
                <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<c:url value="/car/"/>">Liste véhicule</a>
                    <a class="dropdown-item" href="<c:url value="/car/add"/>">Ajouter</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/parking/add"/>">Maintain parking spot referential</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/pricing"/>">Maintain pricing referential</a>
            </li>
        </ul>
    </div>
</nav>

<div class="m-3">
    &nbsp;
</div>

<section class="container mt-5">
    <div class="container-fluid">
        <div class="row flex-nowrap">
            <div class="col-3 sidebar">
                <div class="container">
                    <h5 class="mb-4">Rechercher</h5>
                    <%--@elvariable id="searchCriteria" type="fr.digicar.model.User"--%>
                    <form:form method="POST" modelAttribute="searchCriteria"
                               action="${pageContext.request.contextPath}/registration">
                        <strong>Nom</strong>
                        <div class="md-form">
                            <input type="email" id="email" class="form-control validate" placeholder="Ex: Jean Dupont"/>
                        </div>
                        <strong>Localisation</strong>
                        <div class="form-group mt-2">
                            <input type="checkbox" id="checkbox1" checked="checked"/>
                            <label for="checkbox1">Paris (75)</label><br/>
                            <input type="checkbox" id="checkbox2" checked="checked"/>
                            <label for="checkbox2">Val-de-Marne (94)</label>
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="col-9 main">
                <h2>Utilisateurs</h2>
                <table class="table table-hover mt-4">
                    <tbody>
                    <%--@elvariable id="users" type="List<fr.digicar.model.User>"--%>
                    <c:if test="${!empty users}">
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td class="align-middle text-center pr-0">
                                    <c:choose>
                                        <c:when test="${user.gender == 'M.'}">
                                            <img src="<c:url value="/resources/img/profile-male.jpg" />" alt="avatar"
                                                 class="rounded-circle img-responsive" height="60px">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="<c:url value="/resources/img/profile-female.jpg" />" alt="avatar"
                                                 class="rounded-circle img-responsive" height="60px">
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="align-middle">
                                    <strong>${user.firstName} ${user.firstName}</strong>
                                    <br/>
                                    <small class="text-muted">${user.city} (${user.zipCode})</small>
                                </td>
                                <td class="align-middle">
                                    <i class="fa fa-bar-chart text-muted"></i> 0 trajet(s)<br/>
                                    <i class="fa fa-credit-card text-muted"></i> 0.00€ dépensé(s)
                                </td>
                                <td class="align-middle">
                                    <i class="fa fa-circle text-success"></i> Actif
                                    <br/>
                                    <small class="text-muted">Inscrit(e) le 18/12/2017</small>
                                </td>
                                <td class="align-middle text-center">
                                    <button class="btn btn-sm btn-primary">
                                        Consulter
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty users}">
                        <tr class="text-center">
                            <td>Aucun utilisateur trouvé</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</section>

</body>
</html>
