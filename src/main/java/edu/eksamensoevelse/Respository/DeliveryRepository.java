package edu.eksamensoevelse.Respository;

import edu.eksamensoevelse.entity.Delivery;
import edu.eksamensoevelse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Optional<Delivery> findById(Long id);
}
