package com.tumi.demo.owner;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotEmpty;

import com.tumi.demo.model.Person;

@Entity
@Table(name="owners")
public class Owner extends Person{  //duennos de las mascotas

    @Column(name = "address")
    @NotEmpty
	private String address;
	
    @Column(name = "city")
    @NotEmpty    
	private String city;
	
    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
	private String telephone;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="owner")
    private Set<Pet> pets;

    
    
    
    
	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}
