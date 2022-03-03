package se.bth.pa2552_project;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.function.Function;

public class MainScreenController {
    public Label errorText;

    // The input fields
    public TextField fahrenheitInput;
    public TextField mpsInput;
    public TextField minuteInput;
    public TextField gallonInput;
    public TextField gramsInput;

    public Label celsiusOutput;
    public Label kmhOutput;
    public Label hourOutput;
    public Label litersOutput;
    public Label ouncesOutput;

    private void handleConversion(TextField input, Label output, Function<Double, Double> converter) {
        String inputString = input.getText();
        if (inputString.length() < 1) {
            errorText.setText("You need to input at least one digit to convert!");
            output.setText("");
        } else {
            try {
                double inputVal = Double.parseDouble(inputString);
                double outputVal = converter.apply(inputVal);
                output.setText(String.format("%.2f", outputVal));
                errorText.setText("");
            } catch (NumberFormatException e) {
                output.setText("");
                errorText.setText("You need to enter a number!");
            }
        }
    }

    public void onTemperatureConvert() {
        handleConversion(fahrenheitInput, celsiusOutput, UnitConversion::fahrenheitToCelsius);
    }

    public void onSpeedConvert() {
        handleConversion(mpsInput, kmhOutput, UnitConversion::metersPerSecondToKilometersPerHour);
    }

    public void onTimeConvert() {
        handleConversion(minuteInput, hourOutput, UnitConversion::minutesToHours);
    }

    public void onVolumeConvert() {
        handleConversion(gallonInput, litersOutput, UnitConversion::gallonToLiter);
    }

    public void onWeightConvert() {
        handleConversion(gramsInput, ouncesOutput, UnitConversion::gramsToOunces);
    }
}
