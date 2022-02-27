package com.dictionary.ws.core.SecurityConfiguration;

import com.fasterxml.jackson.core.filter.TokenFilter;
import org.springframework.stereotype.Component;

@Component
public class CustomTokenFilter extends TokenFilter {
    protected CustomTokenFilter() {
        super();
    }

}
