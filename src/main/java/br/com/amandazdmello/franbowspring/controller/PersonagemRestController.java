package br.com.amandazdmello.franbowspring.controller;

import br.com.amandazdmello.franbowspring.model.Personagem;
import br.com.amandazdmello.franbowspring.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personagens")
public class PersonagemRestController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public ResponseEntity<Iterable<Personagem>> buscarTodos() {
        return ResponseEntity.ok(personagemService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personagemService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Personagem> inserir(@RequestBody Personagem personagem) {
        personagemService.inserir(personagem);
        return ResponseEntity.ok(personagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> atualizar(@PathVariable Long id, @RequestBody Personagem personagem) {
        personagemService.atualizar(id, personagem);
        return ResponseEntity.ok(personagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        personagemService.deletar(id);
        return ResponseEntity.ok().build();
    }


}
