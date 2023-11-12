package com.example.apifrete.service;

import com.example.apifrete.model.Transportadora;
import com.example.apifrete.repository.TransportadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportadoraService {

    @Autowired
    private final TransportadoraRepository transportadoraRepository;

    public TransportadoraService(TransportadoraRepository transportadoraRepository) {
        this.transportadoraRepository = transportadoraRepository;
    }

    public List<Transportadora> obterLista() {
        return (List<Transportadora>) transportadoraRepository.findAll();
    }

    public Transportadora obterPorCnpj(String cnpj) {
        return transportadoraRepository.findByCnpj(cnpj);
    }

    public Transportadora obterPorId(Long id){
        return transportadoraRepository.findById(id);
    }

    public Transportadora salvar(Transportadora transportadora) {
        return transportadoraRepository.save(transportadora);
    }

    public void excluir(Long id) {
        transportadoraRepository.deleteById(id);
    }

    public void atualizar(Transportadora transportadora){
        transportadoraRepository.update(transportadora);
    }

}