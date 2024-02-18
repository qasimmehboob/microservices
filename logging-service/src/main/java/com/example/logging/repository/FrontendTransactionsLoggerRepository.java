package com.example.logging.repository;

import com.example.logging.model.FrontendTransactionsLogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface FrontendTransactionsLoggerRepository extends JpaRepository<FrontendTransactionsLogger, Long> {
}
