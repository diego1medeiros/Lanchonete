package br.com.lanchonete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.lanchonete.entity.Fornecedor;
import br.com.lanchonete.service.FornecedorServiceImpl;
import br.com.lanchonete.utils.Message;

@Named(value = "fornecedorbean")
@RequestScoped
public class FornecedorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Fornecedor> fornecedores = new ArrayList<>();
	
	@Inject
	private FornecedorServiceImpl fornecedorServiceImpl;

	private Fornecedor fornecedor = new Fornecedor();
	
//cadastar e atualizar fornecedores do banco de dados
	public String cadastrarFornecedor() {
		try {
			if(fornecedor.getIdFornecedor()== null) {
				fornecedorServiceImpl.cadastrarFornecedor(fornecedor);
				Message.info("Fornecedor cadastrado com Sucesso!!!");
			}else {
				fornecedorServiceImpl.editarFornecedor(fornecedor);
				Message.info("Fornecedor Atualizado com Sucesso!!!");
			}
			listaDadosDosFornecedores();
			limpar();
		} catch (Exception e) {
		}
		return null;
	}

	// lista fornecedores do banco de dados
	@PostConstruct
	public void listaDadosDosFornecedores() {
		fornecedores = fornecedorServiceImpl.listaDadosDosFornecedors();
	}

	// excluir fornecedores do banco de dados
	public void excluirFornecedor(Fornecedor fornecedor) {
		try {
			fornecedorServiceImpl.removerFornecedor(fornecedor);
			Message.erro("Fornecedor excluido com Sucesso!!!");
			listaDadosDosFornecedores();
			limpar();
		} catch (Exception e) {
		}
	}
	
	//limpar dados da tela
	public void limpar() {
		fornecedor = new Fornecedor();
	}

	public FornecedorServiceImpl getFornecedorServiceImpl() {
		return fornecedorServiceImpl;
	}

	public void setFornecedorServiceImpl(FornecedorServiceImpl fornecedorServiceImpl) {
		this.fornecedorServiceImpl = fornecedorServiceImpl;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;

	}

	public void setFornecedores(List<Fornecedor> fornecedors) {
		this.fornecedores = fornecedors;

	}

	
	

}
