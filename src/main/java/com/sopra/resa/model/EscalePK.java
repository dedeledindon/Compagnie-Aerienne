package com.sopra.resa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class EscalePK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "ID_VOL")
	private Vol vol;
	@ManyToOne
	@JoinColumn(name = "ID_AEROPORT")
	private Aeroport aeroport;

	/**
	 * @param vol
	 * @param aeroport
	 */
	public EscalePK(Vol vol, Aeroport aeroport) {
		super();
		this.vol = vol;
		this.aeroport = aeroport;
	}

	public EscalePK() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the vol
	 */
	public Vol getVille() {
		return vol;
	}

	/**
	 * @param vol
	 *            the vol to set
	 */
	public void setVille(Vol vol) {
		this.vol = vol;
	}

	/**
	 * @return the aeroport
	 */
	public Aeroport getAeroport() {
		return aeroport;
	}

	/**
	 * @param aeroport
	 *            the aeroport to set
	 */
	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

}
