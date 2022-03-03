package se.bth.pa2552_project.system;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import se.bth.pa2552_project.UnitConverterApplication;
import se.bth.pa2552_project.system.utils.HeadlessHelper;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class UnitConverterSystemTest {
    @BeforeAll
    public static void setupForHeadlessTesting() {
        HeadlessHelper.setupForHeadlessTesting();
    }


    @BeforeEach
    public void setup() throws Exception {
        ApplicationTest.launch(UnitConverterApplication.class);
    }

    @Test
    public void testEmptyInputValidation(FxRobot robot) {
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);
        Label errorText = robot.lookup("#errorText").queryAs(Label.class);

        fahrenheitInput.setText("");
        robot.clickOn(convertButton);

        assertThat(celsiusOutput.getText())
                .isEmpty();
        assertThat(errorText.getText())
                .isNotEmpty()
                .isEqualTo("You need to input at least one digit to convert!");
    }

    @Test
    public void testLetterInputValidation(FxRobot robot) {
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);
        Label errorText = robot.lookup("#errorText").queryAs(Label.class);

        fahrenheitInput.setText("Hello! äöü=!=? \"exit()\"");
        robot.clickOn(convertButton);

        assertThat(celsiusOutput.getText())
                .isEmpty();
        assertThat(errorText.getText())
                .isNotEmpty()
                .isEqualTo("You need to enter a number!");
    }

    @Test
    public void testFtoC(FxRobot robot) {
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);

        fahrenheitInput.setText("67");
        robot.clickOn(convertButton);

        assertThat(celsiusOutput.getText())
                .isNotEmpty()
                .isEqualTo("19.44");
    }
}
