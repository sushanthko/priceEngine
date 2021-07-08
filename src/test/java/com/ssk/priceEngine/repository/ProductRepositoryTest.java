package com.ssk.priceEngine.repository;

import com.ssk.priceEngine.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void createProduct() {
        Product test = new Product("Test", 50, 1000);

        entityManager.persist(test);
        entityManager.flush();

        Optional<Product> found = productRepository.findById(1L);

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getName()).isEqualTo(test.getName());
    }

}