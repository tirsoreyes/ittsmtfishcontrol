package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TPrecio;

@Repository
public interface ITPrecioDao extends JpaRepository<TPrecio, Integer>{

}
