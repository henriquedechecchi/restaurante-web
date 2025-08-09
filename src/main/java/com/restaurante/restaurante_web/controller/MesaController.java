package com.restaurante.restaurante_web.controller;

import com.restaurante.restaurante_web.model.Mesa;
import com.restaurante.restaurante_web.repository.MesaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mesas")
public class MesaController {

    private final MesaRepository mesaRepository;

    public MesaController(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mesas", mesaRepository.findAll());
        model.addAttribute("mesa", new Mesa());
        return "mesas";
    }

    @PostMapping
    public String salvar(@ModelAttribute Mesa mesa) {
        mesaRepository.save(mesa);
        return "redirect:/mesas";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        mesaRepository.deleteById(id);
        return "redirect:/mesas";
    }
}
