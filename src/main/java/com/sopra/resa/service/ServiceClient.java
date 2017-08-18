package com.sopra.resa.service;

import java.util.List;

import com.sopra.resa.model.Clientspring;
import com.sopra.resa.model.LoginSpring;

/**
 * 
 * ServiceClient = service métier (business service) avec gestion des
 * transactions (commit, rollback) + traitements spécifiques au métier (banque
 * ou aviation ou ...)
 * 
 * avec certains sous traitements qui seront délégués au(x) DAO(s)
 *
 */

public interface ServiceClient {
	public Clientspring rechercherClient(Long id);

	public void majClient(Clientspring client); // mettre à jour client

	public List<Clientspring> findClientByName(String nom);

	// ...
	public Clientspring insertClientWithLogin(Clientspring cli, LoginSpring login);

	public void supprimerClientWithLogin(Long idClient);

	public Clientspring rechercherClientAvecResa(Long id);
}
