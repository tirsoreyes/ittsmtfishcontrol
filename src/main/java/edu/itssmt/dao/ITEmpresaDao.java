package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TEmpresa;


@Repository
public interface ITEmpresaDao extends JpaRepository<TEmpresa, Integer>{

	
}
