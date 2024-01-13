module com.demo.fxgldemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    requires com.almasb.fxgl.all;

    opens com.demo.fxgldemo to javafx.fxml;
    exports com.demo.fxgldemo;
    exports com.demo.fxgldemo.factories;
    opens com.demo.fxgldemo.factories to javafx.fxml;
}