package com.lozhensky.OrderTransferService.project;

import com.lozhensky.OrderTransferService.dto.Prod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int orderId;
    private String clientName;
    private List<Prod> prodlist;
    private String status;

    public void setStatus(String newStatus)
    {
        this.status = newStatus;
    }
}
