package com.dmytroverner.microservicessampleproj.currencyconversionservice;

import com.dmytroverner.microservicessampleproj.currencyconversionservice.bean.CurrencyConversionBean;
import com.dmytroverner.microservicessampleproj.currencyexchangeservice.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        logger.info("response={}", response);

        return new CurrencyConversionBean(
                response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
