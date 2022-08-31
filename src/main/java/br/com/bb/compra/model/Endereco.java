package br.com.bb.compra.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
public class Endereco {
    private Long id;
    @NotNull
    @NotBlank
    private String logradouro;
    @NotNull @NotBlank
    private String bairro;
    @NotNull @NotBlank
    private String cidade;
    @NotNull @NotBlank
    private String uf;
    @NotNull @NotBlank
    private String cep;
}
