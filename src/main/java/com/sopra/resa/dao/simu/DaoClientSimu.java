package com.sopra.resa.dao.simu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sopra.resa.dao.DaoClient;
import com.sopra.resa.model.Clientspring;

/*
 * DaoClientSimu = Simulation sans base de donnees
 */
//@Component
//@Repository("daoClientSimu") //composant de type dao
@Repository // id par defaut = Nom de la classe avec minuscule au début
public class DaoClientSimu implements DaoClient {

	@Override
	public Clientspring findByKey(Long idClient) {
		return new Clientspring(idClient,"nomxx","prenomyy");
	}

	@Override
	public List<Clientspring> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientspring insert(Clientspring client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clientspring update(Clientspring client) {
		// TODO Auto-generated method stub
        return null;
	}

	@Override
	public void delete(Clientspring client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Clientspring> findClientByName(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
