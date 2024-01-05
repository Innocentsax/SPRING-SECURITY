package dev.Innocent.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAtFilter implements Filter {

    private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        LOG.info("Authentication Validation is in progress");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
