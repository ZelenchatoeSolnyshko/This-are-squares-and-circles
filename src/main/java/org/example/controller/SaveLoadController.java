package org.example.controller;

import org.example.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SaveLoadController {
    private Model model;
    public void save() {

    }

    public void load() {

    }

    @Autowired
    public void setModel(Model model) {
        this.model = model;
    }
}
