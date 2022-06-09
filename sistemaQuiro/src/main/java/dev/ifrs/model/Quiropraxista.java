package dev.ifrs.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Quiropraxista extends PanacheEntityBase{
    
	//regra id
	@Id
	@SequenceGenerator(
		name = "quiroSeq",
		sequenceName = "pquiro_id_seq",	
		allocationSize = 1,
		initialValue = 2000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiroSeq")
	public Long id;

    //Atributos
	
	private String nome;
	private String cpf;
	private String email;
	private String crm;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // name = nome da coluna que irá armazenar a chave estrangeira
    // na tabela Message (solução a partir da JPA 2)
    @JoinColumn(name="Consultas_Quiro")
	@JsonBackReference
	private Set<Consulta> consultas;

	//precisa de consultas?

	//Contrutores
	public Quiropraxista() {};
	public Quiropraxista(String nome, String cpf, String email, String crm) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		
	}
	
	public Quiropraxista(String nome, String cpf, String email, String crm, Set<Consulta> consultas) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.crm = crm;
		this.consultas = consultas;
	}
	

	//Getters e Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}

	public void addConsulta(Consulta consulta) {
		this.consultas.add(consulta);
	}
	
}
