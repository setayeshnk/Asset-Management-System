package com.example.demo.suppliers.service;

import com.example.demo.ExceptionHandling.RecordNotFoundException;
import com.example.demo.suppliers.model.SupplierCompany;
import com.example.demo.suppliers.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    //Create Supplier
    public SupplierCompany createSupplier(SupplierCompany supplier) {
        Optional<SupplierCompany> supplierCompany=supplierRepository.findById(supplier.getSupplierId());
        if (supplierCompany.isPresent()) {
            SupplierCompany newSupplier = supplierCompany.get();
            newSupplier.setSupplierName(supplier.getSupplierName());
            newSupplier =supplierRepository.save(newSupplier);
            return newSupplier;
        }
        else {
            supplier=supplierRepository.save(supplier);
            return supplier;
        }
    }

    //Read Supplier
    public List<SupplierCompany> readSuppliers() {
        List<SupplierCompany> supplierCompanies= (List<SupplierCompany>) supplierRepository.findAll();
        if (supplierCompanies.size() > 0) {
            return supplierCompanies;
        } else
            return new ArrayList<SupplierCompany>();
    }

    //Update Supplier
    public SupplierCompany updateSupplier(SupplierCompany supplier) {
        Optional<SupplierCompany> supplierCompany=supplierRepository.findById(supplier.getSupplierId());
        if (supplierCompany.isPresent()) {
            SupplierCompany newSupplier = supplierCompany.get();
            newSupplier.setSupplierName(supplier.getSupplierName());
            newSupplier =supplierRepository.save(newSupplier);
            return newSupplier;
        }
        else {
            supplier=supplierRepository.save(supplier);
            return supplier;
        }
    }

    //Delete Supplier
    public void deleteSupplierById(int supplierId) throws RecordNotFoundException {
        Optional<SupplierCompany> supplier=supplierRepository.findById(supplierId);

        if (supplier.isPresent()){
            supplierRepository.deleteById(supplierId);
        }
        else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }


}
