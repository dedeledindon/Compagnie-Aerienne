package com.sopra.resa.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.resa.dao.DaoClient;
import com.sopra.resa.dao.DaoLogin;
import com.sopra.resa.model.Clientspring;
import com.sopra.resa.model.LoginSpring;

//@Component
@Service // id par defaut = serviceClientImpl
@Transactional
public class ServiceClientImpl implements ServiceClient {

	private Logger logger = LoggerFactory.getLogger(ServiceClientImpl.class);

	// à ajouter en TP : référence "private" sur DaoClient
	@Autowired
	private DaoClient daoClient = null;

	@Autowired
	private DaoLogin daoLogin = null;

	public ServiceClientImpl() {
		System.out.println("dans constructeur, daoClient=" + daoClient);
		// daoClient.setXyz("..."); declencherait ici nullPointerException
	}

	// @PostConstruct ou bien init-method="initAfterInject" dans <bean ...>
	public void initAfterInject() {
		System.out.println("dans initAfterInject, daoClient=" + daoClient);
		// daoClient.setXyz("..."); possible ici
	}

	// à ajouter en TP : setter public pour injection de dépendances
	// @Autowired
	public void setDaoClient(DaoClient daoClient) {
		this.daoClient = daoClient;
		System.out.println("dans setDaoClient, daoClient=" + daoClient);
	}
	// à faire en TP : coder les méthodes en déléguant au dao:

	@Override
	public Clientspring rechercherClient(Long id) {
		return daoClient.findByKey(id);
	}

	@SuppressWarnings("rawtypes")
	public static void loadlazyCollection(Collection col) {
		col.size(); // method pour charger une collection lorsqu'une lazy exception spawn
	}

	@Override
	// @Transactional
	public Clientspring rechercherClientAvecResa(Long id) {
		Clientspring client = daoClient.findByKey(id);
		loadlazyCollection(client.getListeResa());
		return client;
	}

	@Override
	public Clientspring insertClientWithLogin(Clientspring cli, LoginSpring login) {
		Clientspring savedClient = null;
		try {
			savedClient = daoClient.insert(cli);
			login.setIdClient(savedClient.getIdClient());
			LoginSpring savedLogin = daoLogin.insert(login);
			savedClient.setLogin(savedLogin);
		} catch (Exception e) {
			logger.error("echec insertClientWithLogin", e);
			throw new RuntimeException("echec insertClientWithLogin", e);
		}
		return savedClient;
	}

	@Override
	// @Transactional // obligatoire ici pour que client et login restent
	// persistants
	// avant de les retransmettre à daoXyz.delete()
	public void supprimerClientWithLogin(Long idClient) {
		Clientspring client = daoClient.findByKey(idClient);
		LoginSpring login = daoLogin.findByKey(idClient);
		if (login != null)
			daoLogin.delete(login);// ordre selon contrainte du schema
		if (client != null)
			daoClient.delete(client);
	}

	@Override
	public void majClient(Clientspring client) {
		daoClient.update(client);
	}

	@Override
	public List<Clientspring> findClientByName(String nom) {
		return daoClient.findClientByName(nom);
	}

}
