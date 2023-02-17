package br.com.lanchonete.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import br.com.lanchonete.dao.ProdutoDao;
import br.com.lanchonete.entity.Produto;

@RequestScoped
public class ProdutoServiceImpl implements ProdutoService {

	@Inject
	private ProdutoDao produtoDao;

	@Override
	public Produto cadastrarProduto(Produto produto) {
		return produtoDao.cadastrarProduto(produto);
	}

	@Override
	public List<Produto> listaDadosDosProdutos() {
		return produtoDao.listaDadosDosProdutos();
	}

	@Override
	public Produto removerProduto(Produto produto) {
		return produtoDao.removerProduto(produto);
	}

	@Override
	public Produto editarProduto(Produto produto) {
		return produtoDao.editarProduto(produto);
	}

}
