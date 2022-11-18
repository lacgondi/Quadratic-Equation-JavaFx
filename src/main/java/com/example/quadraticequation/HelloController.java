package com.example.quadraticequation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField first;
    public TextField second;
    public TextField third;
    public Button calcButton;
    public Label xlabelone;
    public Label xlabeltwo;
    @FXML
    private Label welcomeText;

    @FXML
    public void calcButtonClick(ActionEvent actionEvent) {
        double firstnumber = 0;
        double secondnumber = 0;
        double thirdnumber = 0;

        try{
            firstnumber = Double.parseDouble(first.getText());
            secondnumber = Double.parseDouble(second.getText());
            thirdnumber = Double.parseDouble(third.getText());
        }catch(NumberFormatException e){
            System.out.println("Kérem csak számokat adjon meg.");
        }
        System.out.println(firstnumber);
        System.out.println(secondnumber);
        System.out.println(thirdnumber);
        quadraticEquation(firstnumber, secondnumber, thirdnumber);
    }

    @FXML
    public void quadraticEquation(double fx, double sx, double tx){ //first x, second x, third x
        //(-b +- sqrt(b^2 - 4 * a * c)) / 2a

        double inSqrt = Math.pow(sx, 2) - (4 * fx * tx);
        double x1sum = -sx + Math.sqrt(inSqrt) / (2 * fx);
        double x2sum = -sx - Math.sqrt(inSqrt) / (2 * fx);

        if(inSqrt < 0){
            System.out.println("Ez az egyenlet nem oldható meg a valós számok halmazán.");
        }
        else if(x1sum < 0){
            xlabelone.setVisible(false);
            xlabeltwo.setText("x2 = " + x2sum);
        }
        else if(x2sum < 0){
            xlabeltwo.setVisible(false);
            xlabelone.setText("x1 = " + x1sum);
        }
        else{
            xlabeltwo.setText("x2 = " + x2sum);
            xlabelone.setText("x1 = " + x1sum);
        }

    }
}