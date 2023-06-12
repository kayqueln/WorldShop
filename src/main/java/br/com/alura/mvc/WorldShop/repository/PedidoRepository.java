package br.com.alura.mvc.WorldShop.repository;

import br.com.alura.mvc.WorldShop.model.Pedido;

import br.com.alura.mvc.WorldShop.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido statusPedido);
}
