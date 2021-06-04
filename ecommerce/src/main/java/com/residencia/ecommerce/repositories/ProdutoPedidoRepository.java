package com.residencia.ecommerce.repositories;

import com.residencia.ecommerce.entities.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido,Integer> {
}
