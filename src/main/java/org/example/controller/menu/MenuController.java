package org.example.controller.menu;

import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.fill.Fill;
import org.example.model.shape.fill.FillBehavior;
import org.example.model.shape.fill.NoFill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MenuController {

    private Color selectedColor;

    private FillBehavior selectedFill;
    private ShapeType selectedShape;

    private MenuObserver observer;

    @Autowired
    public void setObserver(MenuObserver observer) {
        this.observer = observer;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public FillBehavior getSelectedFill() {
        return selectedFill;
    }

    public ShapeType getSelectedShape() {
        return selectedShape;
    }

    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");

        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(e -> {
            selectedShape = ShapeType.RECTANGULAR;
            observer.notifyAllSubscribers();
        });
        shapeMenu.add(square);
        group.add(square);

        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(e -> {
            selectedShape = ShapeType.ELLIPSE;
            observer.notifyAllSubscribers();
        });
        shapeMenu.add(ellipse);
        group.add(ellipse);

        JRadioButtonMenuItem roundRectangular = new JRadioButtonMenuItem("Закругленный прямоугольник");
        roundRectangular.addActionListener(e -> {
            selectedShape = ShapeType.ROUND_RECTANGULAR;
            observer.notifyAllSubscribers();
        });
        shapeMenu.add(roundRectangular);
        group.add(roundRectangular);

        return shapeMenu;
    }

    private JMenu createColorMenu() {
        JMenu colorMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();

        JRadioButtonMenuItem colorBlue = new JRadioButtonMenuItem("Синий");
        colorBlue.addActionListener(e -> {
            selectedColor = Color.BLUE;
            observer.notifyAllSubscribers();
        });
        colorMenu.add(colorBlue);
        group.add(colorBlue);

        JRadioButtonMenuItem colorRed = new JRadioButtonMenuItem("Красный");
        colorRed.addActionListener(e -> {
            selectedColor = Color.RED;
            observer.notifyAllSubscribers();
        });
        colorMenu.add(colorRed);
        group.add(colorRed);

        JRadioButtonMenuItem colorGreen = new JRadioButtonMenuItem("Зеленый");
        colorGreen.addActionListener(e -> {
            selectedColor = Color.GREEN;
            observer.notifyAllSubscribers();
        });
        colorMenu.add(colorGreen);
        group.add(colorGreen);
        return colorMenu;
    }

    private JMenu createFillMenu() {
        JMenu fillMenu = new JMenu("Заливка");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem fill = new JRadioButtonMenuItem("Заливка есть");
        fill.addActionListener(e -> {
            selectedFill = new Fill();
            selectedFill.setColor(selectedColor);
            MyShape shape = selectedShape.createMyShape(selectedColor, selectedFill);
            selectedFill.serShape(shape.getShape());
            observer.notifyAllSubscribers();
        });
        fillMenu.add(fill);
        group.add(fill);

        JRadioButtonMenuItem noFill = new JRadioButtonMenuItem("Нет заливки");
        noFill.addActionListener(e -> {
            selectedFill = new NoFill();
            selectedFill.setColor(selectedColor);
            MyShape shape = selectedShape.createMyShape(selectedColor, selectedFill);
            selectedFill.serShape(shape.getShape());
            observer.notifyAllSubscribers();
        });
        fillMenu.add(noFill);
        group.add(noFill);

        return fillMenu;
    }

    public void defaultState() {
        selectedColor = Color.CYAN;
        selectedFill = new NoFill();
        selectedShape = ShapeType.ROUND_RECTANGULAR;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menu = new JMenuBar();

        JMenu colorMenu = createColorMenu();
        menu.add(colorMenu);

        JMenu fillMenu = createFillMenu();
        menu.add(fillMenu);

        JMenu shapeMenu = createShapeMenu();
        menu.add(shapeMenu);

        defaultState();

        return menu;
    }
}
