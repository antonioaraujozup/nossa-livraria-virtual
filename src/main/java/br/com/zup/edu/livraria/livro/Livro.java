package br.com.zup.edu.livraria.livro;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String resumo;


    @Column(nullable = false)
    private String autor;


    @Column(nullable = false)
    @org.hibernate.validator.constraints.ISBN(type = org.hibernate.validator.constraints.ISBN.Type.ANY)
    private String ISBN;


    public Livro(String nome, String resumo, String autor, String ISBN) {
        this.nome = nome;
        this.resumo = resumo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    /**
     * @deprecated construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Livro() {
    }

    public Long getId() {
        return id;
    }
}
