package com.wit.computeVoteModule.filters;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

public class SampleFilter extends Filter<ILoggingEvent> {

    public FilterReply decide(ILoggingEvent event) {
        if (event.getThreadName().contains("RabbitListenerEndpointContainer")) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.DENY;
        }
    }

}