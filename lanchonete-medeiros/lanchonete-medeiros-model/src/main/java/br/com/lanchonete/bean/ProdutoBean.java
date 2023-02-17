package br.com.lanchonete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.lanchonete.entity.Fornecedor;
import br.com.lanchonete.entity.Produto;
import br.com.lanchonete.service.FornecedorServiceImpl;
import br.com.lanchonete.service.ProdutoServiceImpl;
import br.com.lanchonete.utils.Message;

@Named(value = "produtobean")
@RequestScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Produto> produtos = new ArrayList<>();
	private Produto produto = new Produto();
	@Inject
	private FornecedorServiceImpl fornecedorServiceImpl;

	@Inject
	private ProdutoServiceImpl produtoServiceImpl;

	// cadastrar e atualizar produtos no banco de dados
	public String cadastrarProduto() {
		try {
			if (produto.getIdProduto() == null) {
				produtoServiceImpl.cadastrarProduto(produto);
				Message.info("Produto cadastrado com sucesso!!");
				
			} else {
				produtoServiceImpl.editarProduto(produto);
				Message.info("Produto atualizado com sucesso!!");
			}
			listaDadosDosProdutos();
			limpar();
		} catch (Exception e) {
		}
		return null;
	}

	// lista imformações  dos produtos vido do banco de dados
	@PostConstruct
	public void listaDadosDosProdutos() {
		produtos = produtoServiceImpl.listaDadosDosProdutos();
	}

	//excluir produtos do banco de dados
	public void excluirProduto(Produto produto) {
		try {
			produtoServiceImpl.removerProduto(produto);
			listaDadosDosProdutos();
			limpar();
			Message.erro("Produto excluido com sucesso!!");

		} catch (Exception e) {

		}
	}

	//lista fornecedores no combobox
	public List<SelectItem> getLista() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		List<Fornecedor> listaFornecedores = fornecedorServiceImpl.listaDadosDosFornecedors();
		for (Fornecedor fornecedor : listaFornecedores) {
			list.add(new SelectItem(fornecedor.getIdFornecedor(), fornecedor.getRazaoSocial()));

		}
		return list;
	}

	// lista dados da tela
	public void limpar() {
		produto = new Produto();

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoServiceImpl getProdutoServiceImpl() {
		return produtoServiceImpl;
	}

	public void setProdutoServiceImpl(ProdutoServiceImpl produtoServiceImpl) {
		this.produtoServiceImpl = produtoServiceImpl;
	}

	public List<Produto> getProdutos() {
		return produtos;

	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;

	}

}
