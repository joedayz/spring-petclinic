package com.tumi.demo.owner;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.tumi.demo.model.NamedEntity;

@Entity
@Table(name ="pets")
public class Pet extends NamedEntity{  //mascota

	//constructor sin argumentos es OBLIGATORIO
	
	@Column(name="birth_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	@ManyToOne
	@JoinColumn(name="type_id")  //FK
	private PetType type;
	
	@ManyToOne
	@JoinColumn(name="owner_id")  //FK
	private Owner owner;

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	
}
