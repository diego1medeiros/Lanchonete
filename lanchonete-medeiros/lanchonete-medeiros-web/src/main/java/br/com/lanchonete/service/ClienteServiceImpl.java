package br.com.lanchonete.service;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import br.com.lanchonete.dao.ClienteDao;
import br.com.lanchonete.entity.Cliente;

@RequestScoped
public class ClienteServiceImpl implements ClienteService {

	@Inject
	private ClienteDao clienteDao;

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteDao.cadastrarCliente(cliente);
	}
	
	@Override
	public List<Cliente> listaDadosDosClientes() {
		return clienteDao.listaDadosDosClientes();
	}

	@Override
	public Cliente removerCliente(Cliente cliente) {
		return clienteDao.removerCliente(cliente);
	}
	@Override
	public Cliente editarCliente(Cliente cliente) {
		return clienteDao.editarCliente(cliente);
	}

}
