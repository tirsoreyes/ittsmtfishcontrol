package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.THorario;

@Repository
public interface ITHorarioDao extends JpaRepository<THorario, Integer>{

	
}
