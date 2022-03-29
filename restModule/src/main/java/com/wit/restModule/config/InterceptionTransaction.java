package com.wit.restModule.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class InterceptionTransaction implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptionTransaction.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        UUID uuid = UUID.randomUUID();
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        MDC.put("requestId", String.valueOf(uuid));
        httpServletResponse.setHeader("requestId", String.valueOf(uuid));

        LOGGER.info("start request");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("finish request");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
