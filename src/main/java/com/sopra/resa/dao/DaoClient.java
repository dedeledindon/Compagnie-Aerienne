package com.sopra.resa.dao;

import java.util.List;

import com.sopra.resa.model.Clientspring;

/*
 * DaoClient = Data Access Object
 *         alias "Data Service" alias "repository spring"
 *   avec methodes CRUD
 *   et throws RuntimeException implicites
 */
public interface DaoClient extends DaoGeneric<Clientspring,Long>{
    
    public List<Clientspring> findClientByName(String nom);
	
}    
