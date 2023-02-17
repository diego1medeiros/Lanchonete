package br.com.lanchonete.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import br.com.lanchonete.entity.Produto;

@Stateless
public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;

	public ProdutoDao() {
		super();
	}

	@Transactional
	public Produto cadastrarProduto(Produto produto) {
		manager.persist(produto);
		return produto;
	}

	@Transactional
	public List<Produto> listaDadosDosProdutos() {
		List<Produto> listaProdutos = null;
		listaProdutos = manager.createQuery("select p from Produto p", Produto.class).getResultList();
	
		return listaProdutos;
	}

	@Transactional
	public Produto removerProduto(Produto produto) {
		produto = manager.merge(produto);
		manager.remove(produto);
		return produto;
	}

	@Transactional
	public Produto editarProduto(Produto produto) {
		manager.merge(produto);
		return produto;
	}
}
