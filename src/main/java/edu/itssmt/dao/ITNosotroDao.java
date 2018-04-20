package edu.itssmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.itssmt.entity.TNosotro;

@Repository
public interface ITNosotroDao extends JpaRepository<TNosotro, Integer>{

}
