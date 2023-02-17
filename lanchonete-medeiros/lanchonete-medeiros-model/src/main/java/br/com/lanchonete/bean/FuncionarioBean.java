package br.com.lanchonete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.lanchonete.entity.Funcionario;
import br.com.lanchonete.service.FuncionarioServiceImpl;
import br.com.lanchonete.utils.Message;

@Named(value = "funcionariobean")
@RequestScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Funcionario> funcionarios = new ArrayList<>();

	private Funcionario funcionario = new Funcionario();
	@Inject
	private FuncionarioServiceImpl serviceImpl;

	// cadastar e atualizar Funcionarios do banco de dados
	public String cadastrarFuncionario() {
		try {
			if (funcionario.getEndereco() == null) {
				serviceImpl.cadastrarFuncionario(funcionario);
				Message.info("Funcionario cadastrado com Sucesso!!!");
			} else {
				serviceImpl.editarFuncionario(funcionario);
				Message.info("Funcionario Atualizado com Sucesso!!!");
			}
			listaDadosDosFuncionarios();
			limpar();
		} catch (Exception e) {
		}
		return null;
	}

	// lista Funcionarios do banco de dados
	@PostConstruct
	public void listaDadosDosFuncionarios() {
		funcionarios = serviceImpl.listaDadosDosFuncionarios();
	}

	// excluir Funcionarios do banco de dados
	public void excluirFuncionario(Funcionario funcionario) {
		try {
			serviceImpl.removerFuncionario(funcionario);
			listaDadosDosFuncionarios();
			limpar();
			Message.erro("Funcionario excluido com Sucesso!!!");
		} catch (Exception e) {
		}
	}

	// logar no sistema
	public String isLoginSenhaValida(String login, String senha) {
		try {
			List<Funcionario> listaFuncionarios = serviceImpl.listaDadosDosFuncionarios();
			for (Funcionario funcionario : listaFuncionarios) {
				if (login.equals(funcionario.getLogin()) && senha.equals(funcionario.getSenha())) {
					Message.info("Login e Senha valida!!!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getSessionMap().put("funcionarioLogado", funcionario);
					return "menuPrincipal?faces-redirect-true";
				}
			}
		} catch (Exception e) {
		}
		Message.erro("Login e Senha errada!!!");
		return null;
	}

	// deslogar do sistema
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("funcionarioLogado");
		return "login?faces-redirect-true";
	}

	// lista dados da tela
	public void limpar() {
		funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioServiceImpl getServiceImpl() {
		return serviceImpl;
	}

	public void setServiceImpl(FuncionarioServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;

	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;

	}

}
