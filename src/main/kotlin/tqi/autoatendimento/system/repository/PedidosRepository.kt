package tqi.autoatendimento.system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import tqi.autoatendimento.system.entity.Categoria
import tqi.autoatendimento.system.entity.Pedidos

@Repository
interface PedidosRepository: JpaRepository<Pedidos, Long> {

    @Query(value = "SELECT * FROM pedidos WHERE cod_venda = :cod", nativeQuery = true)
    fun findByCodVenda(@Param("cod") cod: String): List<Pedidos>

}