package com.example.apifrete.service;

import com.example.apifrete.model.Frete;
import com.example.apifrete.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class FreteService {

    @Autowired
    private FreteRepository freteRepository;

    public List<Frete> findAll() {
        return freteRepository.findAll();
    }

    public Optional<Frete> findById(Long id) {
        return freteRepository.findById(id);
    }

    public Frete save(Frete frete) {
        return freteRepository.save(frete);
    }

    public void deleteById(Long id) {
        freteRepository.deleteById(id);
    }

    public Frete update(Frete frete) {
        if (frete.getId() == null || !freteRepository.existsById(frete.getId())) {
            throw new IllegalArgumentException("O frete com este id não existe");
        }
        return freteRepository.save(frete);
    }
}