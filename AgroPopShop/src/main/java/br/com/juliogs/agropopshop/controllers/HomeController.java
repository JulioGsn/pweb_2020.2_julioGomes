package br.com.juliogs.agropopshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.juliogs.agropopshop.model.Produto;
import br.com.juliogs.agropopshop.repositories.ProdutoRepository;

@Controller
@RequestMapping
public class HomeController {
    @Autowired
    ProdutoRepository produtoRepo;

    @GetMapping("/")
    public ModelAndView index() {
        List<Produto> lista = produtoRepo.findAll();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("produtos", lista);
        return mav;
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }

}
