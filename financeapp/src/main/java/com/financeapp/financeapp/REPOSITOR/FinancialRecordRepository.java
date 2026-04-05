package com.financeapp.financeapp.REPOSITOR;

import com.financeapp.financeapp.RecordType;
import com.financeapp.financeapp.model.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(RecordType type);

    List<FinancialRecord> findByCategory(String category);


    List<FinancialRecord> findByDateBetween(LocalDate start, LocalDate end);
}
