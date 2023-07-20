package tqi.autoatendimento.system.entity

import jakarta.persistence.*
import tqi.autoatendimento.system.enum.FormaPagamento
import tqi.autoatendimento.system.enum.UnidadeMedida
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "pedidos")
data class Pedidos(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, length = 30) val nomeProduto: String,
    @Column(nullable = false, length = 30) val idProduto: Long? = null,
    @Column(nullable = false, columnDefinition = "DECIMAL(10,2)") val precoUnitario: BigDecimal,
    @Column(nullable = false) val quantidade: Int,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false) val formaPagamento: FormaPagamento,
    @Column(nullable = false) val codVenda: String

)
