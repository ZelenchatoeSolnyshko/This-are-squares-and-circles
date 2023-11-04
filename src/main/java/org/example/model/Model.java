package org.example.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Component
public class Model extends Observable {
    private MyShape currentShape;
    private List<MyShape> list;

    @PostConstruct
    public void init() {
        list = new ArrayList<>();
    }

    public void changeShape() {
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }

    public void createCurrentShape(MyShape shape) {
        currentShape = shape;
        list.add(currentShape);
        this.setChanged();
        this.notifyObservers();
    }

    public List<MyShape> getList() {
        return list;
    }
}
