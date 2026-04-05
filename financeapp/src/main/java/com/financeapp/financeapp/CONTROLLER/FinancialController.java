package com.financeapp.financeapp.CONTROLLER;

import com.financeapp.financeapp.RecordType;
import com.financeapp.financeapp.SERVICELAYER.FinancialService;
import com.financeapp.financeapp.model.FinancialRecord;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/finance")
public class FinancialController {

    @Autowired
    private FinancialService service;

    //  Create Record (ADMIN only)
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> create(@Valid @RequestBody FinancialRecord record) {
        FinancialRecord saved = service.create(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //  Get All Records (ALL roles)
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    //  Delete Record (ADMIN only)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

    //  Summary API (Dashboard)
    @GetMapping("/summary")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public ResponseEntity<?> summary() {

        Map<String, Double> data = new HashMap<>();
        data.put("totalIncome", service.totalIncome());
        data.put("totalExpense", service.totalExpense());
        data.put("netBalance", service.balance());

        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FinancialRecord record) {
        return ResponseEntity.ok(service.update(id, record));
    }

    @GetMapping("/filter")
    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    public ResponseEntity<?> filter(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) RecordType type) {

        return ResponseEntity.ok(service.filter(category, type));
    }
}