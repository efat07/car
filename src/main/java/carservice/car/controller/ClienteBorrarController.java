package carservice.car.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import carservice.car.model.Cliente;
import carservice.car.repository.ClienteRepository;

@Scope(value = "session")
@Component(value = "clienteBorrarController")
@ELBeanName(value = "clienteBorrarController")
@Join(path = "/borrar", to = "/clienteBorrar-form.jsf")
public class ClienteBorrarController {
    
	@Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente = new Cliente();
    
    public String borrar() {
        try {
        	clienteRepository.save(cliente);
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