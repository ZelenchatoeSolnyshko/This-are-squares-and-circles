package org.example.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO: 25.10.2024 Сделать singleton класс
public class Model extends Observable {
    private List<MyShape> shapeList = new ArrayList<>();
    public void createCurrentShape(MyShape shape){
        shapeList.add(shape);
    }

    public void draw(Graphics2D g) {
        shapeList.forEach(shape -> shape.draw(g));
    }
    public void update()
    {
        this.setChanged();
        this.notifyObservers();
    }
}
