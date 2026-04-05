package com.financeapp.financeapp.SERVICELAYER;

import com.financeapp.financeapp.REPOSITOR.FinancialRecordRepository;
import com.financeapp.financeapp.RecordType;
import com.financeapp.financeapp.model.FinancialRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getAll() {
        return repo.findAll();
    }

    public double totalIncome() {
        return repo.findByType(RecordType.INCOME)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double totalExpense() {
        return repo.findByType(RecordType.EXPENSE)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }

    public double balance() {
        return totalIncome() - totalExpense();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public FinancialRecord update(Long id, FinancialRecord updated) {
        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setAmount(updated.getAmount());
        record.setCategory(updated.getCategory());
        record.setType(updated.getType());
        record.setDate(updated.getDate());
        record.setDescription(updated.getDescription());

        return repo.save(record);
    }

    public List<FinancialRecord> filter(String category, RecordType type) {

        if (category != null) {
            return repo.findByCategory(category);
        }

        if (type != null) {
            return repo.findByType(type);
        }

        return repo.findAll();
    }
}
