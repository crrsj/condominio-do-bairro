package com.Condominio.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Condominio.dto.CadastrarMorador;
import com.Condominio.modelo.Condominio;
import com.Condominio.repositorio.CondominioRepositorio;




@RestController
public class CondominioControle {
	
	@Autowired
	private CondominioRepositorio repositorio;
	

 
	
    @PostMapping(value = "cadastrar")
	public ResponseEntity<CadastrarMorador>cadastrar(@RequestBody CadastrarMorador cadastro,UriComponentsBuilder uriBuilder ){
		
		var cadastre = new Condominio(cadastro);
		repositorio.save(cadastre);
		var uri = uriBuilder.path("/cadastrarCond/{id}").buildAndExpand(cadastre.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastrarMorador(cadastre));
		
	}
    
    	   
   
    @GetMapping(value = "buscarPorNome")
	@ResponseBody
	public ResponseEntity<List<Condominio>>buscarPorNome(@RequestParam(name = "name" ) String name){
	    List<Condominio> morador = repositorio.buscarPorNome(name.trim().toUpperCase());
		return new ResponseEntity<List<Condominio>>(morador,HttpStatus.OK);
	}
    
    @DeleteMapping(value = "excluir")
	@ResponseBody
	public ResponseEntity<String>delete(@RequestParam Long idmorador ){
	    repositorio.deleteById(idmorador);
		return new ResponseEntity<String>("Morador deletado com sucesso",HttpStatus.OK);
	}
	
    @GetMapping(value = "buscarMoradorid")
	@ResponseBody
	public ResponseEntity<Condominio>buscarmoradorid(@RequestParam(name = "idmorador" ) Long idmorador){
	   var morador = repositorio.findById(idmorador).get();
	   return new ResponseEntity<Condominio>(morador,HttpStatus.OK);
	
	}
}
