package edu.itssmt.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.itssmt.entity.TUsuarioGrupoEmpresa;

@Repository
public interface ITUsuarioGrupoEmpresaDao extends JpaRepository<TUsuarioGrupoEmpresa, Integer>{
	

	
	
	@Modifying
	@Transactional
    @Query(nativeQuery = true, value = "INSERT INTO t_usuario_grupo_empresa  (t_empresa_Id, t_grupo_Id, t_usuario_Id) VALUES(?1,?2,?3)")
    int saveNewRelation(@Param("t_empresa_Id") int t_empresa_Id, @Param("t_grupo_Id") int t_grupo_Id,@Param("t_usuario_Id") int t_usuario_Id);
	
	
	
	
	
}
