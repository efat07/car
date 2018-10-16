package carservice.car.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import carservice.car.model.Cliente;
import carservice.car.repository.ClienteRepository;

@Scope(value = "session")
@Component(value = "clienteActualizaController")
@ELBeanName(value = "clienteActualizaController")
@Join(path = "/actualizar", to = "/clienteActulizar-form.jsf")
public class ClienteActualizaController {
    
	@Autowired
    private ClienteRepository clienteRepository;
    private Cliente cliente = new Cliente();
    
    public String actualizar() {
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