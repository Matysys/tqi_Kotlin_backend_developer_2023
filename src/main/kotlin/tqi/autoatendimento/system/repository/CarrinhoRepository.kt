package tqi.autoatendimento.system.repository

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.lang.Nullable
import org.springframework.stereotype.Repository
import tqi.autoatendimento.system.entity.Carrinho
import java.math.BigDecimal

@Repository
interface CarrinhoRepository: JpaRepository<Carrinho, Long> {

    @Query(value = "SELECT * FROM carrinho", nativeQuery = true)
    fun findAllProdutos(): List<Carrinho>

    @Transactional
    @Modifying
    @Query(value = "UPDATE carrinho SET quantidade_produto = :quantidadeProduto, preco_produto = :precoProduto WHERE nome_produto = :nomeProduto", nativeQuery = true)
    fun update(@Param("nomeProduto") nomeProduto: String, @Param("quantidadeProduto") quantidadeProduto: Int, @Param("precoProduto") precoProduto: BigDecimal)

    @Transactional
    @Modifying
    @Query("TRUNCATE TABLE carrinho", nativeQuery = true)
    fun truncateAll()

    @Nullable //Para corrigir o erro de retornar null
    @Query("SELECT id_produto FROM carrinho WHERE id_produto = :produtoId", nativeQuery = true)
    fun existsCarrinho(@Param("produtoId") produtoId: Long): Any

}