package com.restaurante.restaurante_web.controller;

import com.restaurante.restaurante_web.model.Comanda;
import com.restaurante.restaurante_web.model.Mesa;
import com.restaurante.restaurante_web.model.Cliente;
import com.restaurante.restaurante_web.repository.ComandaRepository;
import com.restaurante.restaurante_web.repository.MesaRepository;
import com.restaurante.restaurante_web.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/comandas")
public class ComandaController {

    private final ComandaRepository comandaRepository;
    private final MesaRepository mesaRepository;
    private final ClienteRepository clienteRepository;

    public ComandaController(ComandaRepository comandaRepository,
                             MesaRepository mesaRepository,
                             ClienteRepository clienteRepository) {
        this.comandaRepository = comandaRepository;
        this.mesaRepository = mesaRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("comandas", comandaRepository.findAll());
        model.addAttribute("comanda", new Comanda());
        // Adicionar listas para validação no frontend
        model.addAttribute("mesas", mesaRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
        return "comandas";
    }

    @PostMapping
    public String salvar(@RequestParam Long mesaId,
                         @RequestParam Long clienteId,
                         @RequestParam(defaultValue = "false") boolean fechada,
                         RedirectAttributes redirectAttributes) {

        try {
            // Buscar mesa e cliente pelos IDs
            Mesa mesa = mesaRepository.findById(mesaId).orElse(null);
            Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

            // Validações mais amigáveis
            if (mesa == null) {
                redirectAttributes.addFlashAttribute("erro",
                        "Mesa com ID " + mesaId + " não encontrada. Verifique se a mesa existe.");
                return "redirect:/comandas";
            }

            if (cliente == null) {
                redirectAttributes.addFlashAttribute("erro",
                        "Cliente com ID " + clienteId + " não encontrado. Verifique se o cliente existe.");
                return "redirect:/comandas";
            }

            // Criar nova comanda
            Comanda comanda = new Comanda();
            comanda.setMesa(mesa);
            comanda.setCliente(cliente);
            comanda.setFechada(fechada);

            comandaRepository.save(comanda);
            redirectAttributes.addFlashAttribute("sucesso", "Comanda criada com sucesso!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro",
                    "Erro ao criar comanda: " + e.getMessage());
        }

        return "redirect:/comandas";
    }

    @GetMapping("/delete/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            comandaRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("sucesso", "Comanda excluída com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir comanda: " + e.getMessage());
        }
        return "redirect:/comandas";
    }
}