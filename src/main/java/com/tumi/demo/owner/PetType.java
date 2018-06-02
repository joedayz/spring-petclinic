package com.tumi.demo.owner;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.tumi.demo.model.NamedEntity;

@Entity
@Table(name="types")
public class PetType extends NamedEntity {

}
