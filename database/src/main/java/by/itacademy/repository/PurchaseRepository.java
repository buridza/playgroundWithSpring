package by.itacademy.repository;

import by.itacademy.entity.Purchase;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PurchaseRepository extends PagingAndSortingRepository<Purchase, Long> {
}
