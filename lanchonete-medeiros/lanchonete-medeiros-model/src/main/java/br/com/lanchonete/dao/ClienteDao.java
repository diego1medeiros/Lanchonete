package br.com.lanchonete.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import br.com.lanchonete.entity.Cliente;

@Stateless
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;


	public ClienteDao() {
		super();
	}

	@Transactional
	public Cliente cadastrarCliente(Cliente cliente) {
		
		manager.persist(cliente);
		return cliente;
	}

	@Transactional
	public List<Cliente> listaDadosDosClientes() {
		List<Cliente> listaClientes = null;
		listaClientes = manager.createQuery("select c from Cliente c", Cliente.class).getResultList();
		return listaClientes;
	}

	@Transactional
	public Cliente removerCliente(Cliente cliente) {
		cliente = manager.merge(cliente);
		manager.remove(cliente);
		return cliente;
	}
	
	@Transactional
	public Cliente editarCliente(Cliente cliente) {
		manager.merge(cliente);
		return cliente;
	}
}
