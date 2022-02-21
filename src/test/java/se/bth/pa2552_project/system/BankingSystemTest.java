package se.bth.pa2552_project.system;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import se.bth.pa2552_project.BankingApplication;
import se.bth.pa2552_project.system.utils.HeadlessHelper;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class BankingSystemTest {
    @BeforeAll
    public static void setupForHeadlessTesting() {
        HeadlessHelper.setupForHeadlessTesting();
    }


    @BeforeEach
    public void setup() throws Exception {
        ApplicationTest.launch(BankingApplication.class);
    }

    @Test
    public void testButtonClick(FxRobot robot) {
        Button helloButton = robot.lookup("#helloButton").queryButton();
        Label helloLabel = robot.lookup("#welcomeText").queryAs(Label.class);
        assertThat(helloLabel.getText()).isEmpty();

        robot.clickOn(helloButton);

        assertThat(helloLabel.getText())
                .isNotEmpty()
                .isEqualTo("Welcome to JavaFX Application!");
    }
}
