package edu.itssmt.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.itssmt.entity.TCita;

@Repository
public interface ITCitaDao extends JpaRepository<TCita, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM t_cita where Id=?1 AND Fecha_Cita BETWEEN ?2 AND ?3")
	public List<TCita> findCitaByEmpresaAndFechaCita(int id, Date fechaCitaInicio, Date fechaCitaFin);
	
}
