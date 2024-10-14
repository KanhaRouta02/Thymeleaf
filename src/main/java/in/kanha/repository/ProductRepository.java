package in.kanha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kanha.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
