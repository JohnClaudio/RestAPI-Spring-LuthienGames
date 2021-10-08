package com.br.generation.luthiengames.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_categoria;

    @Size(max=30, message ="O campo nome categoria não pode exceder 30 caracteres")
    @NotNull(message ="O campo nome categoria não pode ser nulo")
    private String nome;

    @Size(max=30, message ="O campo descricao categoria não pode exceder 30 caracteres")
    @NotNull(message ="O campo descricao categoria não pode ser nulo")
    private String Descricao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at = new java.sql.Date((System.currentTimeMillis()));
}
