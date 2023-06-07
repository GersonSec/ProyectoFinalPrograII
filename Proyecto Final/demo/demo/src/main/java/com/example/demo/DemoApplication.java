package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends Application {

    private TextField nameField;
    private TextField ageField;
    private Label outputLabel;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Demo Application");

        // Crear los campos de entrada
        nameField = new TextField();
        ageField = new TextField();

        // Crear una etiqueta para mostrar los datos ingresados
        outputLabel = new Label();

        // Crear un botón para mostrar los datos ingresados
        Button showButton = new Button("Mostrar Datos");
        showButton.setOnAction(e -> mostrarDatos());

        // Crear el diseño de la ventana
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
                new Label("Nombre:"),
                nameField,
                new Label("Edad:"),
                ageField,
                showButton,
                outputLabel
        );

        // Crear la escena y mostrarla en la ventana
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarDatos() {
        String nombre = nameField.getText();
        int edad = Integer.parseInt(ageField.getText());

        // Mostrar los datos ingresados en la etiqueta
        String mensaje = "Nombre: " + nombre + "\nEdad: " + edad;
        outputLabel.setText(mensaje);
    }
}
