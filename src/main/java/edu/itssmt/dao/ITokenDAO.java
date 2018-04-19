package edu.itssmt.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TToken;


@Repository
public interface ITokenDAO extends JpaRepository<TToken, Integer> {

	public TToken findByToken (String token);
		
}
