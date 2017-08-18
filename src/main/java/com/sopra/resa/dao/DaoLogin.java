package com.sopra.resa.dao;

import com.sopra.resa.model.LoginSpring;

/*
 * DaoLogin = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoLogin extends DaoGeneric<LoginSpring,Long>{
    
    public LoginSpring findLoginByUsername(String username);
	
}    
