package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TGrupo;

@Repository
public interface ITGrupoDao extends JpaRepository<TGrupo, Integer>{

}
