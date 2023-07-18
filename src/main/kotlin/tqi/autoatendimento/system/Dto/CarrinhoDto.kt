package tqi.autoatendimento.system.Dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import tqi.autoatendimento.system.entity.Carrinho
import java.math.BigDecimal

class CarrinhoDto (
    @NotBlank
    @Size(max = 30)
    val nomeProduto: String = "",
    @NotBlank
    val idProduto: Long,
    @NotBlank
    @Size(max = 30)
    val quantidadeProduto: Int
){
    fun toEntity(): Carrinho = Carrinho(
        idProduto = this.idProduto,
        nomeProduto = this.nomeProduto,
        quantidadeProduto = this.quantidadeProduto
    )

}