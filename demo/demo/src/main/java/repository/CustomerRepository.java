package repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<com.example.demo.entity.Customer, Long> {

}
