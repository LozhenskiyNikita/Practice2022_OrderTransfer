package com.lozhensky.OrderTransferService.service;

import com.lozhensky.OrderTransferService.dto.OrderDto;
import com.lozhensky.OrderTransferService.project.Order;
import com.lozhensky.OrderTransferService.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public void persistOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);

        final RestTemplate restTemplate = new RestTemplate();
        final String stringPosts = restTemplate.getForObject("http://localhost:8080/payment", String.class);
        order.setStatus(stringPosts);

        Order persistedOrder = orderRepository.save(order);

        log.info("order persisted {}", persistedOrder);
    }

}
