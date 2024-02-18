package com.example.logging.repository;

import com.example.logging.model.BackendTransactionsLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendTransactionsLoggerRepository extends JpaRepository<BackendTransactionsLogger, Long> {
}
