<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!--/.Navbar-->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Ajouter un véhicule
</button>

<%@include file="carFilter.jsp" %>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ajouter un véhicule</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <%--@elvariable id="car" type="fr.digicar.model.Car"--%>
            <form:form method="POST" action="${pageContext.request.contextPath}/car/add" modelAttribute="car">
                <div class="modal-body">

                    <div class="md-form">
                        <form:input type="text" path="registration_number" cssClass="form-control" required="required"/>
                        <form:label path="registration_number">Immatriculation</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="mark" cssClass="form-control"/>
                        <form:label data-error="Marque invalide" path="mark">Marque</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="name_model" cssClass="form-control"/>
                        <form:label data-error="modèle invalide" path="name_model">Nom du modèle</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="transmission" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="transmission">Type de transmission</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="nb_places" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="nb_places">Nombre de places</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="nb_doors" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="nb_doors">Nombre de portes</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="type" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="type">Type de véhicule</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="location" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="location">Emplacement</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="number" path="kilometers" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="kilometers">Kilométrage</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="release_date" cssClass="form-control"/>
                        <form:label data-error="champs invalide"
                                    path="release_date">Date de mise en circulation</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="comfort" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="comfort">Confort</form:label>
                    </div>

                    <div class="md-form">
                        <form:input type="text" path="fuel_type" cssClass="form-control"/>
                        <form:label data-error="champs invalide" path="fuel_type">Type de carburant</form:label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Annuler</button>
                    <button type="submit" class="btn btn-primary">Ajouter un véhicule</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<%@include file="add-car-confirmation.jsp"%>