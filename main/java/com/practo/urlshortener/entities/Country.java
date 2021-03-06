/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practo.urlshortener.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anoop
 */
@Entity
@Table(name = "Country")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c"),
		@NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id"),
		@NamedQuery(name = "Country.findByName", query = "SELECT c FROM Country c WHERE c.name = :name") })
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "Name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private Collection<UrlVisit> urlVisitCollection;

	public Country() {
	}

	public Country(Integer id) {
		this.id = id;
	}

	public Country(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public Collection<UrlVisit> getUrlVisitCollection() {
		return urlVisitCollection;
	}

	public void setUrlVisitCollection(Collection<UrlVisit> urlVisitCollection) {
		this.urlVisitCollection = urlVisitCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Country)) {
			return false;
		}
		Country other = (Country) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Country[ id=" + id + " ]";
	}

}
