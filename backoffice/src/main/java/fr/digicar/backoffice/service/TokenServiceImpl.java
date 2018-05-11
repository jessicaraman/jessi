package fr.digicar.backoffice.service;

import fr.digicar.dao.PricingDAO;
import fr.digicar.dao.TokenDAO;
import fr.digicar.model.Pricing;
import fr.digicar.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenDAO tokenDAO;

    @Override
    public Token getTokenByUserId(int id) {
        return tokenDAO.getTokenByUserID(id);
    }



}
