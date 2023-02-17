package br.com.lanchonete.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.lanchonete.entity.Endereco;

@Stateless
public class EnderecoDao {

	@PersistenceContext
	private EntityManager manager;

	public Endereco cadastrarEndereco(Endereco endereco) {
		System.out.println(" salvo no DaO " + endereco.getBairro());
		manager.persist(endereco);
		return endereco;
		
	}
	public EnderecoDao() {
		super();
	}
	public EnderecoDao(EntityManager manager) {
		super();
		this.manager = manager;
	}
}
