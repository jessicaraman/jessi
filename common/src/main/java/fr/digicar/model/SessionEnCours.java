package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "session_en_cours")
public class SessionEnCours {

  @Id
  @GeneratedValue
  @Column(name = "id_session")
  private int idSession;


  @Column(name = "id_reservation")
  private int idReservation;

  @Column(name = "id_car")
  private int idCar;

  @Column(name = "id_place_depart")
  private int idPlaceDepart;

  @Column(name = "id_place_arrivee")
  private int idPlaceArrivee;

  @Column(name = "heure_depart_reel")
  private java.sql.Timestamp heureDepartReel;

  @Column(name = "heure_arrivee_prevu")
  private java.sql.Timestamp heureArriveePrevu;

  @Column(name = "heure_arrivee_reel")
  private java.sql.Timestamp heureArriveeReel;

  @Column(name = "tarif")
  private double tarif;

  @Column(name = "id_user")
  private int idUser;

  @Column(name = "tag")
  private boolean tag;

  @Column(name = "penality")
  private double penality;

  @Column(name = "latitude_current")
  private int latitudeCurrent;

  @Column(name = "longitude_current")
  private int longitudeCurrent;

  public int getIdSession() {
    return idSession;
  }

  public void setIdSession(int idSession) {
    this.idSession = idSession;
  }


  public int getIdReservation() {
    return idReservation;
  }

  public void setIdReservation(int idReservation) {
    this.idReservation = idReservation;
  }


  public int getIdCar() {
    return idCar;
  }

  public void setIdCar(int idCar) {
    this.idCar = idCar;
  }


  public int getIdPlaceDepart() {
    return idPlaceDepart;
  }

  public void setIdPlaceDepart(int idPlaceDepart) {
    this.idPlaceDepart = idPlaceDepart;
  }


  public int getIdPlaceArrivee() {
    return idPlaceArrivee;
  }

  public void setIdPlaceArrivee(int idPlaceArrivee) {
    this.idPlaceArrivee = idPlaceArrivee;
  }


  public java.sql.Timestamp getHeureDepartReel() {
    return heureDepartReel;
  }

  public void setHeureDepartReel(java.sql.Timestamp heureDepartReel) {
    this.heureDepartReel = heureDepartReel;
  }


  public java.sql.Timestamp getHeureArriveePrevu() {
    return heureArriveePrevu;
  }

  public void setHeureArriveePrevu(java.sql.Timestamp heureArriveePrevu) {
    this.heureArriveePrevu = heureArriveePrevu;
  }


  public java.sql.Timestamp getHeureArriveeReel() {
    return heureArriveeReel;
  }

  public void setHeureArriveeReel(java.sql.Timestamp heureArriveeReel) {
    this.heureArriveeReel = heureArriveeReel;
  }


  public double getTarif() {
    return tarif;
  }

  public void setTarif(double tarif) {
    this.tarif = tarif;
  }


  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public boolean isTag() {
    return tag;
  }

  public void setTag(boolean tag) {
    this.tag = tag;
  }

  public double getPenality() {
    return penality;
  }

  public void setPenality(double penality) {
    this.penality = penality;
  }

  public int getLatitudeCurrent() {
    return latitudeCurrent;
  }

  public void setLatitudeCurrent(int latitudeCurrent) {
    this.latitudeCurrent = latitudeCurrent;
  }

  public int getLongitudeCurrent() {
    return longitudeCurrent;
  }

  public void setLongitudeCurrent(int longitudeCurrent) {
    this.longitudeCurrent = longitudeCurrent;
  }
}

