package com.wit.computeVoteModule.models;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEEPPER, SAUSAGE};
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addToping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        public abstract Pizza build();
        public abstract T self();
    }

    Pizza (Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
