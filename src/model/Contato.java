package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String email;
	@Column
	private Date dataNascimento;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataFormatada(){  
	    String dataFormatada = null;  
	    if(this.getDataNascimento()!=null)  
	    {  
	        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");             
	        dataFormatada = formatador.format(this.getDataNascimento());  
	    }  
	    return dataFormatada;  
	}
	
	
	
}
