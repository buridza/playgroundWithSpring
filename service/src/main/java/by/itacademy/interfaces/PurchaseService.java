package by.itacademy.interfaces;

import by.itacademy.entity.Purchase;
import by.itacademy.impl.Filter;
import org.springframework.data.domain.Page;

public interface PurchaseService {
    Page<Purchase> entities(Filter filter);
}
