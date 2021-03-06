package br.com.juliogs.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.juliogs.agropopshop.model.Cliente;
import br.com.juliogs.agropopshop.repositories.ClienteRepository;

@Controller
@RequestMapping
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepo;

    @GetMapping("/clientes")
    public ModelAndView index() {
        List<Cliente> lista = clienteRepo.findAll();
        ModelAndView mav = new ModelAndView("clientes/index");
        mav.addObject("clientes", lista);
        return mav;
    }

    @GetMapping("/clientes/adicionar")
    public ModelAndView formCadastro() {
        ModelAndView mav = new ModelAndView("clientes/adicionar");
        mav.addObject(new Cliente());
        return mav;
    }

    @PostMapping("/clientes/adicionar")
    public String adicionar(Cliente p) {
        this.clienteRepo.save(p);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public ModelAndView formEditar(@PathVariable("id") long id) {
        Cliente cliente = this.clienteRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));

        ModelAndView modelAndView = new ModelAndView("clientes/editar");
        modelAndView.addObject(cliente);
        return modelAndView;
    }

    @PostMapping("/clientes/editar/{id}")
    public ModelAndView atualizar(@PathVariable("id") long id, Cliente cliente) {
        this.clienteRepo.save(cliente);
        return new ModelAndView("redirect:/clientes");
    }

    @GetMapping("/clientes/remover/{id}")
    public ModelAndView remover(@PathVariable long id) {
        Cliente aRemover = this.clienteRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido:" + id));
        this.clienteRepo.delete(aRemover);
        return new ModelAndView("redirect:/clientes");
    }

}