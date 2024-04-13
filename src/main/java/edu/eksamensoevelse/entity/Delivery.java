package edu.eksamensoevelse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOrder> productOrders;
    //@OneToMany this annotation established a relationship between delivery and productorders. it tells us that
    //delevery can have multiple product orders
    //mappedBy = "delivery": This attribute specifies the field in the ProductOrder entity that owns the relationship

    public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }

}