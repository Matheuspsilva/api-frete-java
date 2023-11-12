package com.example.apifrete.controller;


import com.example.apifrete.model.Destinatario;
import com.example.apifrete.service.DestinatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{cnpj}")
    public Destinatario listarDestinatarioPorCnpj(@PathVariable String cnpj) {

        return destinatarioService.obterPorCnpj(cnpj);

    }

    @PostMapping()
    public String salvarDestinatario(@RequestBody Destinatario destinatario) {

        try {
            destinatarioService.obterPorCnpj(destinatario.getCnpj());
            throw new Exception("CNPJ já cadastrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            destinatarioService.salvar(destinatario);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return "Destinatario salvo com sucesso";
    }

    @DeleteMapping("/{id}")
    public String excluirDestinatario(@PathVariable Long id) {

        try {
            destinatarioService.excluir(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Destinatario excluido com sucesso";
    }

    @PutMapping("/{id}")
    public String atualizarDestinatario(@PathVariable Long id, @RequestBody Destinatario destinatario) {

            try {
                destinatario.setId(id);
                destinatarioService.atualizar(destinatario);
                return "Destinatario atualizado com sucesso";
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar destinatário: " + e);
            }
    }
}