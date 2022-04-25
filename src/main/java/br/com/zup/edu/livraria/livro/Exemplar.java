package br.com.zup.edu.livraria.livro;

import javax.persistence.*;

@Entity
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livro livro;

    @Column(nullable = false)
    private boolean reservado=false;

    public Exemplar(Livro livro) {
        this.livro = livro;
    }

    /**
     * @deprecated construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Exemplar() {
    }

    public void reservar() {
        this.reservado=true;

    }

    public Long getId() {
        return id;
    }
}
