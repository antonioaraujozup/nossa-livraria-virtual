package br.com.zup.edu.livraria.livro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/livros/{isbn}")
public class ReservaLivroController {
    private final ExemplarRepository repository;

    public ReservaLivroController(ExemplarRepository repository) {
        this.repository = repository;
    }

    @PatchMapping
    @Transactional
    public ResponseEntity<?> reservar(@PathVariable("isbn") String ISBN) {
        Exemplar exemplar = repository.findFirstByReservadoIsFalseAndLivro_ISBNEquals(ISBN)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não há exemplar disponível para reserva"));

        exemplar.reservar();

        repository.save(exemplar);

        return ResponseEntity.noContent().build();
    }
}
