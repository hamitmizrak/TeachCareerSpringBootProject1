package com.hamitmizrak.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

//AUDIT CONFIGURATION
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Hamit");
    }
}
