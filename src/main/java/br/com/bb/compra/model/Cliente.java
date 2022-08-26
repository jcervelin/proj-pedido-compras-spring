package br.com.bb.compra.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class Cliente {

    private Long id;
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @Min(value = 18, message = "Deve ser maior de idade")
    @Max(value = 150, message = "Mentiroso")
    private int idade;

}
