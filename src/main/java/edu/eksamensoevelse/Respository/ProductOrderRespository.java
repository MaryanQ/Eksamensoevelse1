package edu.eksamensoevelse.Respository;

import edu.eksamensoevelse.entity.Product;
import edu.eksamensoevelse.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductOrderRespository extends JpaRepository<ProductOrder, Long> {
}