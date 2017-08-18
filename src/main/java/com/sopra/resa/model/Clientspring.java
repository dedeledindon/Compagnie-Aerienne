package com.sopra.resa.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@NamedQuery(name = "Client.findByName", query = "SELECT c FROM Clientspring c WHERE c.nom = :pnom")
public class Clientspring {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;

	@Column(name = "lastName")
	private String nom;

	@Column(name = "firstName")
	private String prenom;

	@OneToOne(mappedBy = "client")
	@PrimaryKeyJoinColumn
	private LoginSpring login;

	@OneToMany(mappedBy = "client")
	private List<Resa> listeResa;

	public Clientspring(Long idClient, String nom, String prenom) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Clientspring() {
		super();
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LoginSpring getLogin() {
		return login;
	}

	public void setLogin(LoginSpring login) {
		this.login = login;
	}

	public List<Resa> getListeResa() {
		return listeResa;
	}

	public void setListeResa(List<Resa> listeResa) {
		this.listeResa = listeResa;
	}

}
