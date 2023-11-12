package com.example.apifrete.service;

import com.example.apifrete.model.Destinatario;
import com.example.apifrete.repository.DestinatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinatarioService {

    @Autowired
    private final DestinatarioRepository destinatarioRepository;

    public DestinatarioService(DestinatarioRepository destinatarioRepository) {
        this.destinatarioRepository = destinatarioRepository;
    }

    public List<Destinatario> obterLista() {
        return (List<Destinatario>) destinatarioRepository.findAll();
    }

    public Destinatario obterPorCnpj(String cnpj) {
        return destinatarioRepository.findByCnpj(cnpj);
    }

    public Destinatario obterPorId(Long id){
        return destinatarioRepository.findById(id);
    }

    public Destinatario salvar(Destinatario destinatario) {
        return destinatarioRepository.save(destinatario);
    }


    public void excluir(Long id) {
        destinatarioRepository.deleteById(id);
    }

    public void atualizar(Destinatario destinatario){
        destinatarioRepository.update(destinatario);
    }

}