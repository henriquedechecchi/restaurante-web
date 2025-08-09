package com.restaurante.restaurante_web.controller;

import com.restaurante.restaurante_web.model.Reserva;
import com.restaurante.restaurante_web.repository.ReservaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaRepository.findAll());
        model.addAttribute("reserva", new Reserva());
        return "reservas";
    }

    @PostMapping
    public String salvar(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }
}
