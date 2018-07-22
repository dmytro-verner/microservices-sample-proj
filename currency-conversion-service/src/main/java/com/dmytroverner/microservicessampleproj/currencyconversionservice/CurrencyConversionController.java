package com.dmytroverner.microservicessampleproj.currencyconversionservice;

import com.dmytroverner.microservicessampleproj.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private Environment environment;

    @GetMapping("currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {
        CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(
                1L, from, to, BigDecimal.ONE, quantity, quantity);
        currencyConversionBean.setPort(Integer.parseInt(environment.getProperty("server.port")));
        return currencyConversionBean;
    }
}
