package com.example.quadraticequation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class QuadController {
    @FXML
    public TextField first;
    @FXML
    public TextField second;
    @FXML
    public TextField third;
    @FXML
    public Button calcButton;
    @FXML
    public Label xlabelone;
    @FXML
    public Label xlabeltwo;

    @FXML
    public void calcButtonClick(ActionEvent actionEvent) {
        double firstNumber = 0;
        double secondNumber = 0;
        double thirdNumber = 0;

        try{
            firstNumber = Double.parseDouble(first.getText());
            secondNumber = Double.parseDouble(second.getText());
            thirdNumber = Double.parseDouble(third.getText());
        }catch(NumberFormatException e){
            System.out.println("Kérem csak számokat adjon meg.");
        }
        System.out.println(firstNumber);
        System.out.println(secondNumber);
        System.out.println(thirdNumber);
        quadraticEquation(firstNumber, secondNumber, thirdNumber);
    }

    @FXML
    public void quadraticEquation(double a, double b, double c){ //first x, second x, third x
        //(-b +- sqrt(b^2 - 4 * a * c)) / 2a

        double inSqrt = Math.pow(b, 2) - (4 * a * c);
        double x1sum = -b + Math.sqrt(inSqrt) / (2 * a);
        double x2sum = -b - Math.sqrt(inSqrt) / (2 * a);

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