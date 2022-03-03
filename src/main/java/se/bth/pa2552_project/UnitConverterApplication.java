package se.bth.pa2552_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;

// This is our converter application,
// when we perform a system test we want to test how a user would navigate and use the application.
// therefore, each component here will be used in a system test.

public class UnitConverterApplication extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UnitConverterApplication.class.getResource("main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 400);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("Unit Converter");
        stage.setScene(scene);
        stage.show();
    }
}
