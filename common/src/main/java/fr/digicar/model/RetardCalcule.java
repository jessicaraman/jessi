package fr.digicar.model;


public class RetardCalcule {

  private long idRetard;
  private String immatriculation;
  private String mark;
  private String model;
  private java.sql.Timestamp heureRetourPrevu;
  private java.sql.Timestamp heureRetourCalcule;
  private double penality;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private long tagAppel;


  public long getIdRetard() {
    return idRetard;
  }

  public void setIdRetard(long idRetard) {
    this.idRetard = idRetard;
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


  public java.sql.Timestamp getHeureRetourPrevu() {
    return heureRetourPrevu;
  }

  public void setHeureRetourPrevu(java.sql.Timestamp heureRetourPrevu) {
    this.heureRetourPrevu = heureRetourPrevu;
  }


  public java.sql.Timestamp getHeureRetourCalcule() {
    return heureRetourCalcule;
  }

  public void setHeureRetourCalcule(java.sql.Timestamp heureRetourCalcule) {
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


  public long getTagAppel() {
    return tagAppel;
  }

  public void setTagAppel(long tagAppel) {
    this.tagAppel = tagAppel;
  }

}
