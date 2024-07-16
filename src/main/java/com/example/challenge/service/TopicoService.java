package com.example.challenge.service;

import com.example.challenge.model.Topico;
import com.example.challenge.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    public Topico save(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> findAll() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return topicoRepository.findById(id);
    }

    @Transactional
    public void deleteById(Long id) {
        topicoRepository.deleteById(id);
    }
}
