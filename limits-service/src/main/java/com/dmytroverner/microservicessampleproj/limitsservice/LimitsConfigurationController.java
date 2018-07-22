package com.dmytroverner.microservicessampleproj.limitsservice;

import com.dmytroverner.microservicessampleproj.limitsservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfigurations() {
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }
}
