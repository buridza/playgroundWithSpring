package by.itacademy.impl;

import by.itacademy.entity.Purchase;
import by.itacademy.interfaces.PurchaseService;
import by.itacademy.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Page<Purchase> allPurchase(Filter filter) {
        return purchaseRepository.findAll(new PageRequest(filter.getNextPage(),filter.getNumberOfRows()));
    }

    @Override
    public Page<Purchase> entities(Filter filter) {
        return purchaseRepository.findAll(new PageRequest(filter.getNextPage(), filter.getNumberOfRows()));
    }
}
