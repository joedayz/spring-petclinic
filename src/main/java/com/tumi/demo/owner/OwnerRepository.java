package com.tumi.demo.owner;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OwnerRepository extends Repository<Owner, Integer>{

	
	@Query("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets "
			+ "	where owner.lastName LIKE :lastName%")
	@Transactional(readOnly=true)
	List<Owner> findByLastName(@Param("lastName") String lastName);
}
