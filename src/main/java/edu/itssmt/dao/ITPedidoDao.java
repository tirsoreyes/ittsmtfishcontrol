package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TPedido;

@Repository
public interface ITPedidoDao extends JpaRepository<TPedido, Integer>{

}
