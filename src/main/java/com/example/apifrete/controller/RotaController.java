package com.example.apifrete.controller;

import com.example.apifrete.model.Rota;
import com.example.apifrete.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rotas")
@RestController
public class RotaController {

    @Autowired
    private RotaService rotaService;

    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @GetMapping()
    public List<Rota> listarRotas() {
        return rotaService.obterLista();
    }

    @GetMapping("/{id}")
    public Rota listarRotaPorId(@PathVariable Long id) {
        return rotaService.obterPorId(id);
    }

    @PostMapping()
    public String salvarRota(@RequestBody Rota rota) {
        try{
            rotaService.salvar(rota);
            return "Rota salva com sucesso";
        } catch (Exception e){
            return "Erro ao salvar rota";
        }

    }

    @DeleteMapping("/{id}")
    public String excluirRota(@PathVariable Long id) {
        try {
            rotaService.excluir(id);
            return "Rota excluída com sucesso";
        } catch (Exception e) {
            return "Erro ao excluir rota";
        }
    }

    @PutMapping("/{id}")
    public String atualizarRota(@PathVariable Long id, @RequestBody Rota rota) {
        try {
            rota.setId(id);
            rotaService.atualizar(rota);
            return "Rota atualizada com sucesso";
        } catch (Exception e) {
            return "Erro ao atualizar rota";
        }
    }
}