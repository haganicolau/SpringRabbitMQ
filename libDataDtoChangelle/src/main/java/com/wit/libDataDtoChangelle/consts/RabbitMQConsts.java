package com.wit.libDataDtoChangelle.consts;

import java.util.ArrayList;
import java.util.List;

public class RabbitMQConsts {
    public static final String QUEUE_CALCULATE = "calculate";
    public static final String QUEUE_RESPONSE = "response";
    public static final String QUEUE_VOTE = "vote";

    public static List<String> getAll() {
        List<String> list = new ArrayList<>();

        list.add(QUEUE_CALCULATE);
        list.add(QUEUE_RESPONSE);
        list.add(QUEUE_VOTE);
        return list;
    }
}
