package br.com.amandazdmello.franbowspring.service.impl;

import br.com.amandazdmello.franbowspring.model.Personagem;
import br.com.amandazdmello.franbowspring.model.PersonagemRepository;
import br.com.amandazdmello.franbowspring.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonagemServiceImpl implements PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Override
    public Iterable<Personagem> buscarTodos() {
        return personagemRepository.findAll();
    }

    @Override
    public Personagem buscarPorId(Long id) {
        Optional<Personagem> personagem = personagemRepository.findById(id);
        return personagem.orElse(null);
    }

    @Override
    public void inserir(Personagem personagem) {
        personagemRepository.save(personagem);
    }

    @Override
    public void atualizar(Long id, Personagem personagem) {
        Optional<Personagem> personagemBd = personagemRepository.findById(id);
        if (personagemBd.isPresent()) {
            if (personagem.getId() == null) {
                personagem.setId(personagemBd.get().getId());
            }
            personagemRepository.save(personagem);
        }
    }

    @Override
    public void deletar(Long id) {
        personagemRepository.deleteById(id);
    }
}
