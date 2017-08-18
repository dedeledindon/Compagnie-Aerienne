package com.sopra.resa.dao.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sopra.resa.dao.DaoLogin;
import com.sopra.resa.model.LoginSpring;


//@Component
@Repository // id par defaut = Nom de la classe avec minuscule au début
@Transactional //en version spring
public class DaoLoginHibernate extends DaoGenericImpl<LoginSpring,Long> implements DaoLogin {
	
	public LoginSpring findLoginByUsername(String username){
	 
	 return em.createNamedQuery("Login.findByUsername",LoginSpring.class)
			 .setParameter("pusername", username)
			 .getSingleResult();
    }


}
