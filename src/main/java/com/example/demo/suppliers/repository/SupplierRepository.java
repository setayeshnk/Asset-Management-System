package com.example.demo.suppliers.repository;

import com.example.demo.suppliers.model.SupplierCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierCompany, Integer> {


}
