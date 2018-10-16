package carservice.car.controller;


import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import carservice.car.model.Cliente;
import carservice.car.repository.ClienteRepository;

import java.util.List;
@Scope (value = "session")
@Component (value = "clienteList")
@ELBeanName(value = "clienteList")
@Join(path = "/", to = "/cliente-list.jsf")
public class ClienteListController {
    @Autowired
    private ClienteRepository clienteRepository;
    private List<Cliente> clientes;
    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        clientes = clienteRepository.findAll();
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
}