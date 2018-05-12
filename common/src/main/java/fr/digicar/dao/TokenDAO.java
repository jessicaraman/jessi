package fr.digicar.dao;

import fr.digicar.model.Car;
import fr.digicar.model.Session;
import fr.digicar.model.Token;

import java.util.Date;
import java.util.List;

public interface TokenDAO {
     Token getTokenByUserID (int id);
     void saveToken(Token t);

}
