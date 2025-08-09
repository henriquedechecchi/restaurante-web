package com.restaurante.restaurante_web.controller;

import com.restaurante.restaurante_web.model.Refeicao;
import com.restaurante.restaurante_web.repository.RefeicaoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/refeicoes")
public class RefeicaoController {

    private final RefeicaoRepository refeicaoRepository;

    public RefeicaoController(RefeicaoRepository refeicaoRepository) {
        this.refeicaoRepository = refeicaoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("refeicoes", refeicaoRepository.findAll());
        model.addAttribute("refeicao", new Refeicao());
        return "refeicoes";
    }

    @PostMapping
    public String salvar(@ModelAttribute Refeicao refeicao) {
        refeicaoRepository.save(refeicao);
        return "redirect:/refeicoes";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        refeicaoRepository.deleteById(id);
        return "redirect:/refeicoes";
    }
}
