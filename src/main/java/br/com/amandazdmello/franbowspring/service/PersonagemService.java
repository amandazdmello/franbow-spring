package br.com.amandazdmello.franbowspring.service;

import br.com.amandazdmello.franbowspring.model.Personagem;

public interface PersonagemService {

    Iterable<Personagem> buscarTodos();

    Personagem buscarPorId(Long id);

    void inserir(Personagem cliente);

    void atualizar(Long id, Personagem cliente);

    void deletar(Long id);
}
