package edu.eksamensoevelse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //manyToOne established a relationship between the 2 entities.
    //it means that many instanses of productorder can be assosiated with the delivery
    //this annotation is placed at the field the represents the owning side of the relationship
    //. In this case, LAZY loading is used. With LAZY loading,
    // the associated Delivery entity will not be loaded from the database until it is explicitly accessed by calling its getter method.
    // This can help improve performance by avoiding unnecessary database queries if the Delivery entity is not always needed when querying ProductOrde
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id") // Assuming the foreign key column is named "product_id"
    private Product product;
}
