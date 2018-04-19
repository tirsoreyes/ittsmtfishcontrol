package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TNuevaEmpresa;



@Repository
public interface ITNuevaEmpresaDao extends JpaRepository<TNuevaEmpresa, Integer>{

	public TNuevaEmpresa findByNombreComercial(String nombreComercial);
}
