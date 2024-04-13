package edu.eksamensoevelse.Respository;

import edu.eksamensoevelse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);
}



