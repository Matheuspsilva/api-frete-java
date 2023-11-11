package com.example.apifrete.controller;


import com.example.apifrete.model.Destinatario;
import com.example.apifrete.service.DestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/destinatarios")
@RestController
public class DestinatarioController {

    @Autowired
    private DestinatarioService destinatarioService;

    public DestinatarioController(DestinatarioService destinatarioService) {
        this.destinatarioService = destinatarioService;
    }

    @GetMapping()
    public List<Destinatario> listarDestinatarios() {

        return destinatarioService.obterLista();

    }
}