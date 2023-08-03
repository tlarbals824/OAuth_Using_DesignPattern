package com.sim.factorypattern.observer.observer;

import com.sim.factorypattern.observer.subject.Status;

@FunctionalInterface
public interface Observer<T extends Status, R> {
    R accept(T status);
}
