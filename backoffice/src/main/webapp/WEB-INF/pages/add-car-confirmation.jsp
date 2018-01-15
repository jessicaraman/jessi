<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<c:if test="${!empty addedCar}">
    <p>Le véhicule avec les caractéristiques ci-dessous a été ajouté :</p>
    <table class="table">
        <tbody>
        <tr>
            <td>Immatriculation</td>
            <td>${addedCar.registration_number}</td>
        </tr>
        <tr>
            <td>Marque</td>
            <td>${addedCar.mark}</td>
        </tr>
        <tr>
            <td>Nom du modèle</td>
            <td>${addedCar.name_model}</td>
        </tr>
        <tr>
            <td>Mode de transmission</td>
            <td>${addedCar.transmission}</td>
        </tr>
        <tr>
            <td>Nombre de places</td>
            <td>${addedCar.nb_places}</td>
        </tr>
        <tr>
            <td>Nombre de portes</td>
            <td>${addedCar.nb_doors}</td>
        </tr>
        <tr>
            <td>Type de véhiclue</td>
            <td>${addedCar.type}</td>
        </tr>
        <tr>
            <td>Emplacement</td>
            <td>${addedCar.location}</td>
        </tr>
        <tr>
            <td>Date de mise en circulation</td>
            <td>${addedCar.release_date}</td>
        </tr>
        <tr>
            <td>Confort</td>
            <td>${addedCar.comfort}</td>
        </tr>
        <tr>
            <td>Type de véhiclue</td>
            <td>${addedCar.type}</td>
        </tr>
        <tr>
            <td>Type de carburant</td>
            <td>${addedCar.fuel_type}</td>
        </tr>
        </tbody>
    </table>
</c:if>