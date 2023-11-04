package org.example.controller.menu;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class MenuObserver {
    private Set<Subscriber> subscribers;

    @PostConstruct
    public void init() {
        subscribers = new HashSet<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifyAllSubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.notifyUpdate();
        }
    }
}
