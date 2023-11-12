package com.example.apifrete.service;

import com.example.apifrete.model.Remetente;
import com.example.apifrete.repository.RemetenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemetenteService {

    @Autowired
    private final RemetenteRepository remetenteRepository;

    public RemetenteService(RemetenteRepository remetenteRepository) {
        this.remetenteRepository = remetenteRepository;
    }

    public List<Remetente> obterLista() {
        return (List<Remetente>) remetenteRepository.findAll();
    }

    public Remetente obterPorCnpj(String cnpj) {
        return remetenteRepository.findByCnpj(cnpj);
    }

    public Remetente obterPorId(Long id){
        return remetenteRepository.findById(id);
    }

    public Remetente salvar(Remetente remetente) {
        return remetenteRepository.save(remetente);
    }

    public void excluir(Long id) {
        remetenteRepository.deleteById(id);
    }

    public void atualizar(Remetente remetente){
        remetenteRepository.update(remetente);
    }

}