package com.example.demo.suppliers.controller;

import com.example.demo.ExceptionHandling.RecordNotFoundException;
import com.example.demo.suppliers.model.SupplierCompany;
import com.example.demo.suppliers.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    //Create Supplier
    @PostMapping("/create")
    public ResponseEntity<SupplierCompany> createSupplier(SupplierCompany supplier) {
        SupplierCompany created=supplierService.createSupplier(supplier);
        return new ResponseEntity<SupplierCompany>(created,new HttpHeaders(), HttpStatus.OK);
    }


    //Read Supplier
    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierCompany>> getAllSupplier(){
        List<SupplierCompany> list=supplierService.readSuppliers();
        return new ResponseEntity<List<SupplierCompany>>(list,new HttpHeaders(), HttpStatus.OK);
    }

    //Update Suplier
    @PutMapping("/update")
    public ResponseEntity<SupplierCompany> updateSupplier(SupplierCompany supplier){
        SupplierCompany updated=supplierService.updateSupplier(supplier);
        return new ResponseEntity<SupplierCompany>(updated,new HttpHeaders(),HttpStatus.OK);
    }

    //Delete Suplier
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteSupplierById(@PathVariable("supplierId") int supplierId) throws RecordNotFoundException {
        supplierService.deleteSupplierById(supplierId);
        return HttpStatus.FORBIDDEN;
    }

}
