package br.com.lanchonete.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
import br.com.lanchonete.entity.Cliente;
import br.com.lanchonete.service.ClienteServiceImpl;
import br.com.lanchonete.utils.Message;

@Named(value = "clientebean")
@RequestScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes = new ArrayList<>();

	private Cliente cliente = new Cliente();

	@Inject
	private ClienteServiceImpl clienteServiceImpl;

	// cadastrar e atualizar Clientes no banco de dados
	public String cadastrarCliente() {
		try {
			if (cliente.getIdCliente() == null) {
				clienteServiceImpl.cadastrarCliente(cliente);
				Message.info("Cliente cadastrado com Sucesso!!!");
			} else {
				clienteServiceImpl.editarCliente(cliente);
				Message.info("Cliente foi Atualizaado com sucesso!!!");
			}
			listaDadosDosClientes();
			limpar();
		} catch (Exception e) {
		}
		return null;
	}

	// lista clientes vindo do banco de dados
	@PostConstruct
	public void listaDadosDosClientes() {
		setClientes(clienteServiceImpl.listaDadosDosClientes());
	}

	// excluir clientes no banco de dados
	public void excluirCliente(Cliente cliente) {
		try {
			clienteServiceImpl.removerCliente(cliente);
			listaDadosDosClientes();
			limpar();
			Message.erro("Cliente foi Excluido com sucesso!!!");
		} catch (Exception e) {
		}
	}

	// limpar dados da tela
	public void limpar() {
		cliente = new Cliente();
	}
	
	public void onRowEdit(RowEditEvent<Cliente> event) {
	     
		  cliente.setNome(String.valueOf(event.getObject().getNome()));
		  clienteServiceImpl.editarCliente(cliente);
		  listaDadosDosClientes();
		  limpar();
	    }

	    public void onRowCancel(RowEditEvent<Cliente> event) {
			Message.info("Alteração do Cliente foi casncelada!!!");
	    }
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;

	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;

	}

}
