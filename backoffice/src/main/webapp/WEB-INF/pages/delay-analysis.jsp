<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>CSC Inside</title>
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
                           aria-haspopup="true" aria-expanded="false">Véhicules</a>
                        <div class="dropdown-menu dropdown-primary" aria-labelledby="navbarDropdownMenuLink">
                            <a class="dropdown-item" href="<c:url value="/car/"/>">Liste des véhicules</a>
                            <a class="dropdown-item" href="<c:url value="/car/add"/>">Ajouter</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/parking"/>">Places de parking</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/pricing"/>">Tarifs</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/users"/>">Utilisateurs</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="m-3">
            &nbsp;
        </div>

        <section class="container mt-3 mb-4">
            <div class="row mb-4">
                <div class="card col">
                    <div class="card-body container pt-4 pb-0">
                        <%--@elvariable id="searchPeriod" type="fr.digicar.backoffice.utils.SearchPeriod"--%>
                        <%--@elvariable id="target" type="java.lang.String"--%>
                        <form:form method="POST" modelAttribute="searchPeriod"
                                   action="${pageContext.request.contextPath}${target}">
                            <div class="row">
                                <div class="col-3">
                                    <div class="mt-4">
                                        <strong>Filtrer par date</strong>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="md-form">
                                        <form:input type="text" onfocus="(this.type='date')" id="dateStart"
                                                    path="startDateString" cssClass="form-control"/>
                                        <form:label for="dateStart" path="startDateString">Date de début</form:label>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="md-form">
                                        <form:input type="text" onfocus="(this.type='date')" id="dateEnd"
                                                    path="endDateString" cssClass="form-control"/>
                                        <form:label for="dateEnd" path="endDateString">Date de fin</form:label>
                                    </div>
                                </div>
                                <div class="col-1">
                                    <button type="submit" class="btn btn-sm btn-primary mt-3">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>

            <div class="row mb-5">
                <div class="col">
                    <a class="btn btn-primary" role="button" href="<c:url value="/delays/filtered"/>">
                        <i class="fa fa-filter"></i>&nbsp;
                        ÉLIMINER LES RETARDS ATYPIQUES
                    </a>
                </div>
            </div>

            <%--@elvariable id="filtered" type="boolean"--%>
            <c:choose>
                <c:when test="${filtered}">
                    <div class="row">
                        <div class="col-5">
                            <h4>Données brutes</h4>
                        </div>
                        <div class="col-1"></div>
                        <div class="col-5">
                            <h4>Données filtrées</h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="card col-5 container">
                            <div class="card-body row">
                                <div class="col-3 text-center" style="border-right: 1px solid darkgrey;">
                                    <h1 class="display-2">
                                        <i class="fa fa-clock-o" aria-hidden="true"></i>
                                    </h1>
                                </div>
                                <div class="col-9">
                                    <h4 class="card-title">
                                        <%--@elvariable id="delayNumber" type="int"--%>
                                        <strong>${delayNumber}</strong>
                                    </h4>
                                    <h5>RETARDS ENREGISTRÉS</h5>
                                    <%--@elvariable id="resultDate" type="String"--%>
                                    <p class="card-text">${resultDate}</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-1"></div>
                        <div class="card col-5 container">
                            <div class="card-body row">
                                <div class="col-3 text-center" style="border-right: 1px solid darkgrey;">
                                    <h1 class="display-2">
                                        <i class="fa fa-clock-o" aria-hidden="true"></i>
                                    </h1>
                                </div>
                                <div class="col-9">
                                    <h4 class="card-title">
                                        <%--@elvariable id="cleanDelayNumber" type="int"--%>
                                        <strong>${cleanDelayNumber}</strong>
                                    </h4>
                                    <h5>RETARDS ENREGISTRÉS</h5>
                                    <%--@elvariable id="cleanResultDate" type="java.lang.String"--%>
                                    <p class="card-text">${cleanResultDate}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <canvas id="standardQuartiles" class="col-6" style="margin: auto;"></canvas>
                        <canvas id="cleanQuartiles" class="col-6" style="margin: auto;"></canvas>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="row">
                        <div class="card col-5 container" style="margin: auto;">
                            <div class="card-body row">
                                <div class="col-3 text-center" style="border-right: 1px solid darkgrey;">
                                    <h1 class="display-2"><i class="fa fa-clock-o" aria-hidden="true"></i></h1>
                                </div>
                                <div class="col-9">
                                    <%--@elvariable id="delayNumber" type="int"--%>
                                    <h4 class="card-title"><strong>${delayNumber}</strong></h4>
                                    <h5>RETARDS ENREGISTRÉS</h5>
                                    <%--@elvariable id="resultDate" type="String"--%>
                                    <p class="card-text">${resultDate}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <canvas id="quartiles" class="col" style="max-width: 600px; margin: auto;"></canvas>
                    </div>
                </c:otherwise>
            </c:choose>

        </section>

        <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/popper.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/mdb.min.js" />"></script>
        <c:choose>
            <c:when test="${filtered}">
                <script type="text/javascript">
                    var ctx1 = document.getElementById("standardQuartiles").getContext('2d');
                    new Chart(ctx1, {
                        type: 'bar',
                        data: {
                            <%--@elvariable id="delayDistributionLabels" type="java.util.List"--%>
                            labels: [
                                '${delayDistributionLabels[0]}',
                                '${delayDistributionLabels[1]}',
                                '${delayDistributionLabels[2]}',
                                '${delayDistributionLabels[3]}'
                            ],
                            datasets: [{
                                label: 'Répartition des retards',
                                data: [
                                    <%--@elvariable id="delayDistribution" type="java.util.List"--%>
                                    ${delayDistribution[0]},
                                    ${delayDistribution[1]},
                                    ${delayDistribution[2]},
                                    ${delayDistribution[3]}
                                ],
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255,99,132,1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                    var ctx2 = document.getElementById("cleanQuartiles").getContext('2d');
                    new Chart(ctx2, {
                        type: 'bar',
                        data: {
                            labels: [
                                <%--@elvariable id="cleanDelayDistributionLabels" type="java.util.List"--%>
                                '${cleanDelayDistributionLabels[0]}',
                                '${cleanDelayDistributionLabels[1]}',
                                '${cleanDelayDistributionLabels[2]}',
                                '${cleanDelayDistributionLabels[3]}'
                            ],
                            datasets: [{
                                label: 'Répartition des retards',
                                data: [
                                    <%--@elvariable id="cleanDelayDistribution" type="java.util.List"--%>
                                    ${cleanDelayDistribution[0]},
                                    ${cleanDelayDistribution[1]},
                                    ${cleanDelayDistribution[2]},
                                    ${cleanDelayDistribution[3]}
                                ],
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255,99,132,1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                </script>
            </c:when>
            <c:otherwise>
                <script type="text/javascript">
                    var ctx = document.getElementById("quartiles").getContext('2d');
                    new Chart(ctx, {
                        type: 'bar',
                        data: {
                            <%--@elvariable id="delayDistributionLabels" type="java.util.List"--%>
                            labels: [
                                '${delayDistributionLabels[0]}',
                                '${delayDistributionLabels[1]}',
                                '${delayDistributionLabels[2]}',
                                '${delayDistributionLabels[3]}'
                            ],
                            datasets: [{
                                label: 'Répartition des retards',
                                <%--@elvariable id="delayDistribution" type="java.util.List"--%>
                                data: [
                                    ${delayDistribution[0]},
                                    ${delayDistribution[1]},
                                    ${delayDistribution[2]},
                                    ${delayDistribution[3]}
                                ],
                                backgroundColor: [
                                    'rgba(255, 99, 132, 0.2)',
                                    'rgba(54, 162, 235, 0.2)',
                                    'rgba(255, 206, 86, 0.2)',
                                    'rgba(75, 192, 192, 0.2)'
                                ],
                                borderColor: [
                                    'rgba(255,99,132,1)',
                                    'rgba(54, 162, 235, 1)',
                                    'rgba(255, 206, 86, 1)',
                                    'rgba(75, 192, 192, 1)'
                                ],
                                borderWidth: 1
                            }]
                        },
                        options: {
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        beginAtZero: true
                                    }
                                }]
                            }
                        }
                    });
                </script>
            </c:otherwise>
        </c:choose>
    </body>
</html>
