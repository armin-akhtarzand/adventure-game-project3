package se.sprinto.hakan.adventuregame.view;

import java.util.List;

public class MultiInputUI implements UI {
    private List <String> inputs;
    private int currentIndex = 0;




    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
        this.currentIndex = 0;
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public String getInput(String prompt) {
        if(inputs != null && currentIndex < inputs.size()) {
            return inputs.get(currentIndex++);
        }
        return null;
    }
}
