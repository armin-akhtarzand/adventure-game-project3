package se.sprinto.hakan.adventuregame.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FakeUI implements UI {

    private String input;


    public void setInput(String input) {
        this.input = input;
    }


    @Override
    public void showMessage(String message) {

    }
    @Override
    public String getInput(String prompt) {
        return input;
    }

}