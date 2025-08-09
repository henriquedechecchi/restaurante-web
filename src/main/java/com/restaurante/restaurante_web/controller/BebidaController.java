package com.restaurante.restaurante_web.controller;

import com.restaurante.restaurante_web.model.Bebida;
import com.restaurante.restaurante_web.repository.BebidaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bebidas")
public class BebidaController {

    private final BebidaRepository bebidaRepository;

    public BebidaController(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("bebidas", bebidaRepository.findAll());
        model.addAttribute("bebida", new Bebida());
        return "bebidas";
    }

    @PostMapping
    public String salvar(@ModelAttribute Bebida bebida) {
        bebidaRepository.save(bebida);
        return "redirect:/bebidas";
    }

    @GetMapping("/delete/{id}")
    public String excluir(@PathVariable Long id) {
        bebidaRepository.deleteById(id);
        return "redirect:/bebidas";
    }
}
