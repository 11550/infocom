package com.severstal.infocom.qualificationtest.service;

import com.severstal.infocom.qualificationtest.model.Supplier;
import com.severstal.infocom.qualificationtest.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService implements ISupplierService {
    private final SupplierRepository supplierRepository;

    @Override
    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier get(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));
    }

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier update(Supplier supplier) {
        return create(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        supplierRepository.delete(supplier);
    }

    @Override
    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public void deleteAll(List<Long> ids) {
        supplierRepository.deleteAllById(ids);
    }
}
