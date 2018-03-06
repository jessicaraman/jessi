package fr.digicar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "retard_calcule")
public class RetardCalcule {

  @Id
  @GeneratedValue
  @Column(name = "id_retard")
  private int id;

  @Column(name = "immatriculation")
  private String immatriculation;

  @Column(name = "mark")
  private String mark;

  @Column(name = "model")
  private String model;

  @Column(name = "heure_retour_prevu")
  private Date heureRetourPrevu;

  @Column(name = "heure_retour_calcule")
  private Date heureRetourCalcule;

  @Column(name = "penality")
  private double penality;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "tag_appel")
  private boolean tagAppel;

  @Column(name = "id_session")
  private int idSession;

  public int getId() {
    return id;
  }

  public void setId(int idRetard) {
    this.id = idRetard;
  }


  public String getImmatriculation() {
    return immatriculation;
  }

  public void setImmatriculation(String immatriculation) {
    this.immatriculation = immatriculation;
  }


  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public Date getHeureRetourPrevu() {
    return heureRetourPrevu;
  }

  public void setHeureRetourPrevu(Date heureRetourPrevu) {
    this.heureRetourPrevu = heureRetourPrevu;
  }


  public Date getHeureRetourCalcule() {
    return heureRetourCalcule;
  }

  public void setHeureRetourCalcule(Date heureRetourCalcule) {
    this.heureRetourCalcule = heureRetourCalcule;
  }


  public double getPenality() {
    return penality;
  }

  public void setPenality(double penality) {
    this.penality = penality;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public boolean getTagAppel() {
    return tagAppel;
  }

  public void setTagAppel(boolean tagAppel) {
    this.tagAppel = tagAppel;
  }

  public int isIdSession() {
    return idSession;
  }

  public void setIdSession(int idSession) {
    this.idSession = idSession;
  }
}
