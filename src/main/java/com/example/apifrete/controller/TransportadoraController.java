package com.example.apifrete.controller;


import com.example.apifrete.model.Transportadora;
import com.example.apifrete.service.TransportadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/transportadoras")
@RestController
public class TransportadoraController {

    @Autowired
    private TransportadoraService transportadoraService;

    public TransportadoraController(TransportadoraService transportadoraService) {
        this.transportadoraService = transportadoraService;
    }

    @GetMapping()
    public List<Transportadora> listarTransportadoras() {

        return transportadoraService.obterLista();

    }

    @GetMapping("/{cnpj}")
    public Transportadora listarTransportadoraPorCnpj(@PathVariable String cnpj) {

        return transportadoraService.obterPorCnpj(cnpj);

    }

    @PostMapping()
    public String salvarTransportadora(@RequestBody Transportadora transportadora) {

        try {
            transportadoraService.obterPorCnpj(transportadora.getCnpj());
            throw new Exception("CNPJ já cadastrado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            transportadoraService.salvar(transportadora);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return "Transportadora salvo com sucesso";
    }

    @DeleteMapping("/{id}")
    public String excluirTransportadora(@PathVariable Long id) {

        try {
            transportadoraService.excluir(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "Transportadora excluido com sucesso";
    }

    @PutMapping("/{id}")
    public String atualizarTransportadora(@PathVariable Long id, @RequestBody Transportadora transportadora) {

            try {
                transportadora.setId(id);
                transportadoraService.atualizar(transportadora);
                return "Transportadora atualizado com sucesso";
            } catch (Exception e) {
                throw new RuntimeException("Erro ao atualizar destinatário: " + e);
            }
    }
}