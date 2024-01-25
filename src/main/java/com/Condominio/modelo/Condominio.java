package com.Condominio.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.Condominio.dto.CadastrarMorador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="condominio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Condominio implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bloco;
	private String apartamento;
	private String garagem;
	private String nome;
	private String telefone;
	private Double agua;
	private Double energia;
	private Double valorCond;	
	private String dataVenc = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String dataPag = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String Status;
	@Column(length = 1000)
	private String anotacao;
    
	public Condominio(CadastrarMorador cadastro) {
		this.id = cadastro.id();
		this.bloco = cadastro.bloco();
		this.apartamento = cadastro.apartamento();
		this.garagem = cadastro.garagem();
		this.nome = cadastro.nome();
		this.telefone = cadastro.telefone();
		this.agua = cadastro.agua();
		this.energia = cadastro.energia();
		this.valorCond = cadastro.valorCond();
		this.dataVenc = cadastro.dataVenc();
		this.dataPag = cadastro.dataPag();
		this.Status = cadastro.status();
		this.anotacao = cadastro.anotacao();
	}

	
	
}
