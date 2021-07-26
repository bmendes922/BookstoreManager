package com.livros.bookstoremanager.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Integer pages;
    @Column(nullable = false)
    private Integer chapters;
    @Column(nullable = false)
    private String isbn;
    @Column(name= "publisher_name", nullable = false, unique = true)
    private String publisherName;
    //significa um para muitos
    // o fetch serve para fazer a consulta dos autores precisa fazer um join para retornar os dados
    //cascade toda vez que adicionar um livro, automaticamente adicione um autor
    //toda vez que atualizar ou remover um livro vai remover um autor junto
    @ManyToOne(fetch= FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    //para dizer qual coluna do nosso banco de dados que vai fazer nosso relacionamento como chave estrangeira
    @JoinColumn(name="author_id")
    private AuthorEntity authorEntity;
}
