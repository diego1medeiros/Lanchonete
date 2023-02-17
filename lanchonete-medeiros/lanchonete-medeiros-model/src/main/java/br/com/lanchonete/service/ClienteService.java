package br.com.lanchonete.service;

import java.util.List;

import javax.ejb.Local;
import br.com.lanchonete.entity.Cliente;

@Local
public interface ClienteService {
	
	public Cliente cadastrarCliente(Cliente cliente) ;
	
	public List<Cliente> listaDadosDosClientes();

	public Cliente removerCliente(Cliente cliente);

	public Cliente editarCliente(Cliente cliente) ;

}
