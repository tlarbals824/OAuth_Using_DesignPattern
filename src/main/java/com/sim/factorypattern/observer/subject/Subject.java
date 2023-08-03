package com.sim.factorypattern.observer.subject;

import com.sim.factorypattern.observer.observer.Observer;

public interface Subject<T,R> {
    void registerObserver(Observer<? extends Status, ?> o);
    void removeObserver(Observer<? extends Status, ?> o);
    R notifyObservers(T object);
}