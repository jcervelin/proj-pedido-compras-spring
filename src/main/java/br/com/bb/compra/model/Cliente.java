package br.com.bb.compra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;
    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotNull(message = "CPF nao pode ser null")
    @NotEmpty(message = "CPF nao pode ser vazio")
    private String cpf;

    @NotNull(message = "Email nao pode ser null")
    @NotEmpty(message = "Email nao pode ser vazio")
    @Email(message = "Email invalido")
    private String email;

}
