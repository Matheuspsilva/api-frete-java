package com.example.apifrete.service;

import com.example.apifrete.model.Rota;
import com.example.apifrete.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;

    public List<Rota> obterLista() {
        return rotaRepository.findAll();
    }

    public Rota obterPorId(Long id) {
        return rotaRepository.findById(id);
    }

    public Rota salvar(Rota rota) {
        return rotaRepository.save(rota);
    }

    public void excluir(Long id) {
        rotaRepository.deleteById(id);
    }

    public Rota atualizar(Rota rota) {
        return rotaRepository.update(rota);
    }

}
