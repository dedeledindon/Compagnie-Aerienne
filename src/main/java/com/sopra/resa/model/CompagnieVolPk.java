package com.sopra.resa.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompagnieVolPk implements Serializable{
	@ManyToOne
	@JoinColumn(name="COMPAGNIE_ID")
	private Compagnie compagnie;
	@ManyToOne
	@JoinColumn(name="VOL_ID")
	private Vol vol;
	
	public CompagnieVolPk() {
		
	}

	public CompagnieVolPk(Compagnie compagnie, Vol vol) {
		this.compagnie = compagnie;
		this.vol = vol;
	}
	
	
	
	

}
