package com.dmytroverner.microservicessampleproj.currencyexchangeservice.repository;

import com.dmytroverner.microservicessampleproj.currencyexchangeservice.bean.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
