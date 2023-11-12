package com.example.apifrete.controller;


import com.example.apifrete.model.Remetente;
import com.example.apifrete.service.RemetenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/remetentes")
@RestController
public class RemetenteController {

    @Autowired
    private RemetenteService remetenteService;

    public RemetenteController(RemetenteService remetenteService) {
        this.remetenteService = remetenteService;
    }

    @GetMapping()
    public List<Remetente> listarRemetentes() {

        return remetenteService.obterLista();

    }

    @GetMapping("/{cnpj}")
    public Remetente listarRemetentePorCnpj(@PathVariable String cnpj) {

        return remetenteService.obterPorCnpj(cnpj);

    }

    @PostMapping()
    public String salvarRemetente(@RequestBody Remetente remetente) {

        try {
            remetenteService.obterPorCnpj(remetente.getCnpj());
            throw new Exception("CNPJ já cadastrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            remetenteService.salvar(remetente);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return "Remetente salvo com sucesso";
    }

    @DeleteMapping("/{id}")
    public String excluirRemetente(@PathVariable Long id) {

        try {
            remetenteService.excluir(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Remetente excluido com sucesso";
    }

    @PutMapping("/{id}")
    public String atualizarRemetente(@PathVariable Long id, @RequestBody Remetente remetente) {

            try {
                remetente.setId(id);
                remetenteService.atualizar(remetente);
                return "Remetente atualizado com sucesso";
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar destinatário: " + e);
            }
    }
}