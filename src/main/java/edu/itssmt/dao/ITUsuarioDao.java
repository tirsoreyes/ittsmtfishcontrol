package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TUsuario;

@Repository
public interface ITUsuarioDao extends JpaRepository<TUsuario, Integer>{

}
