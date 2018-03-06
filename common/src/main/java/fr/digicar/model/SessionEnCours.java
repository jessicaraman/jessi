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
  private long idSession;


  @Column(name = "id_reservation")
  private long idReservation;

  @Column(name = "id_car")
  private long idCar;

  @Column(name = "id_place_depart")
  private long idPlaceDepart;

  @Column(name = "id_place_arrivee")
  private long idPlaceArrivee;

  @Column(name = "heure_depart_reel")
  private java.sql.Timestamp heureDepartReel;

  @Column(name = "heure_arrivee_prevu")
  private java.sql.Timestamp heureArriveePrevu;

  @Column(name = "heure_arrivee_reel")
  private java.sql.Timestamp heureArriveeReel;

  @Column(name = "tarif")
  private double tarif;

  @Column(name = "id_user")
  private long idUser;

  @Column(name = "tag")
  private boolean tag;

  @Column(name = "penality")
  private double penality;

  public long getIdSession() {
    return idSession;
  }

  public void setIdSession(long idSession) {
    this.idSession = idSession;
  }


  public long getIdReservation() {
    return idReservation;
  }

  public void setIdReservation(long idReservation) {
    this.idReservation = idReservation;
  }


  public long getIdCar() {
    return idCar;
  }

  public void setIdCar(long idCar) {
    this.idCar = idCar;
  }


  public long getIdPlaceDepart() {
    return idPlaceDepart;
  }

  public void setIdPlaceDepart(long idPlaceDepart) {
    this.idPlaceDepart = idPlaceDepart;
  }


  public long getIdPlaceArrivee() {
    return idPlaceArrivee;
  }

  public void setIdPlaceArrivee(long idPlaceArrivee) {
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


  public long getIdUser() {
    return idUser;
  }

  public void setIdUser(long idUser) {
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
}
