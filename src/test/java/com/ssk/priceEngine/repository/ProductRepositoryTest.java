package com.ssk.priceEngine.repository;

import com.ssk.priceEngine.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

        Product found = productRepository.findByName("Test");

        assertThat(found.getId()).isPositive();
        assertThat(found.getName()).isEqualTo(test.getName());
    }

}