module se.bth.pa2552_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens se.bth.pa2552_project to javafx.fxml;
    exports se.bth.pa2552_project;
}