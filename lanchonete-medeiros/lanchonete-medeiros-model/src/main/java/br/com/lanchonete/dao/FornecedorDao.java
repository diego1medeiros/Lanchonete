package br.com.lanchonete.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import br.com.lanchonete.entity.Fornecedor;


@Stateless
public class FornecedorDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) {
		manager.persist(fornecedor);
		return fornecedor;
	}

	@Transactional
	public List<Fornecedor> listaDadosDosFornecedors() {
		List<Fornecedor> listaFornecedores = null;
		listaFornecedores = manager.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
		return listaFornecedores;
	}

	@Transactional
	public Fornecedor removerFornecedor(Fornecedor fornecedor) {
		fornecedor = manager.merge(fornecedor);
		manager.remove(fornecedor);
		return fornecedor;
	}

	@Transactional
	public Fornecedor editarFornecedor(Fornecedor fornecedor) {
		manager.merge(fornecedor);
		return fornecedor;
	}

	@Transactional
	public Fornecedor buscarFornecedoresPorId(Long id) {
		Fornecedor fornecedor = manager.find(Fornecedor.class, id);
		return fornecedor ;

	}
	
	
}
