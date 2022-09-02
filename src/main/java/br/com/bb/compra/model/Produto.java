package br.com.bb.compra.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto extends RepresentationModel<Produto> {

    private Long id;

    @NotNull(message = "Nome é obrigatorio")
    private String nome;
    private String descricao;
    @NotNull(message = "Preço é obrigatorio")
    @NotBlank
    private String preco;
    private String desconto;
    private Integer estoque;
    private String foto;

}
