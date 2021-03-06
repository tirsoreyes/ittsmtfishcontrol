package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TBitacora;

@Repository
public interface ITBitacoraDao extends JpaRepository<TBitacora, Integer> {

}
