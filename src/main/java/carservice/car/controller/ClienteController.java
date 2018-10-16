package carservice.car.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import carservice.car.model.Cliente;
import carservice.car.repository.ClienteRepository;

@Scope(value = "session")
@Component(value = "clienteController")
@ELBeanName(value = "clienteController")
@Join(path = "/cliente", to = "/cliente-form.jsf")
public class ClienteController {
    
	@Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente = new Cliente();
    
    public String guardar() {
        try {
        	//clienteRepository.save(cliente);
        	clienteRepository.ins(cliente.getPrimerNombre(), cliente.getPrimerApellido(), cliente.getNumeroIdentificacion());
        	cliente = new Cliente();
		} catch (Exception e) {
			//Retornar error
			e.printStackTrace();
		}
    	
        return "";
      
    }
    public Cliente getCliente() {
        return cliente;
    }
}