package com.lozhensky.OrderTransferService.repository;

import com.lozhensky.OrderTransferService.project.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}