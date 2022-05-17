package com.lozhensky.OrderTransferService.dto;

import lombok.Data;
import lombok.Value;
import java.util.List;

@Data
@Value
public class OrderDto
{
    int orderId;
    String clientName;
    List<Prod> prodlist;
    String status;
}
