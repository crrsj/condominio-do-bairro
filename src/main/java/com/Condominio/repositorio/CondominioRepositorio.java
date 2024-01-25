package com.Condominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Condominio.modelo.Condominio;

public interface CondominioRepositorio extends JpaRepository<Condominio, Long> {
	@Query(value = "select c from Condominio c where upper(trim(c.nome)) like %?1% ") 
	List<Condominio> buscarPorNome(String upperCase);

}
