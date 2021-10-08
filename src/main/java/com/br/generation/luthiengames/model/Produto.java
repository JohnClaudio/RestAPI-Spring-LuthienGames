package com.br.generation.luthiengames.model;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_produto;

    @NotNull(message="O campo nome produto não pode ser nulo")
    @Size(max=100, message = "O campo nome produto não pode exceder 100 carecteres")
    private String nome;

    @NotNull(message="O campo descricao produto não pode ser nulo")
    @Size(max=1000, message = "O campo descricao produto não pode exceder 1000 carecteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Size(max=300, message = "O campo link produto não pode exceder 300 carecteres")
    private String url_img;

    @NotNull(message="O campo quantidade produto não pode ser nulo")
    private int quantidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new java.sql.Date((System.currentTimeMillis()));

}
