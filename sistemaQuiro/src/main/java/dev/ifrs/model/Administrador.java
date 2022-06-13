package dev.ifrs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Administrador extends PanacheEntityBase{
    
    //regra id
	@Id
	@SequenceGenerator(
		name = "admSeq",
		sequenceName = "adm_id_seq",	
		allocationSize = 1,
		initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admSeq")
	public Long id;

    private String nome;
    private String senha;

    //construtores
    public Administrador(){}
    
    public Administrador(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
    }


    //getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public static List<Administrador> findByCredentials(String nome, String senha) {
        List<Administrador> listaN = find("nome", nome).list();
        List<Administrador> listaS = find("senha", senha).list();
        listaN.retainAll(listaS);
        System.out.println(listaN);
        return listaN;
    }


}
