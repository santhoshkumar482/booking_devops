package com.example.demo.controller;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping("/ticket-form")
    public String showForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/submit-ticket")
    public String submitTicket(@ModelAttribute Ticket ticket) {
        ticketRepository.save(ticket);
        return "success";
    }
}
