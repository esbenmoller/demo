package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bachelor program");

        //I disse comboboxes skal der stå navnene på de forskellige fag der kan vælges. her skal dataen fra SQL være.
        ComboBox<String> programComboBox = new ComboBox<>();
        programComboBox.getItems().addAll("HumTek","BP1 HumTek", "BP2 HumTek", "BP3 HumTek", "Bachelorproject HumTek",
                "Design og Konstruktion I+Workshop", "Kunstig intelligens", "Interactive Design in the Field");
        programComboBox.setMaxWidth(Double.MAX_VALUE);

        ComboBox<String> subject1ComboBox = new ComboBox<>();
        subject1ComboBox.getItems().addAll("Computer Science", "Subject module project in Computer Science", "Essential Computing",
                "Software Development", "Interactive Digital Systems");
        subject1ComboBox.setMaxWidth(Double.MAX_VALUE);

        ComboBox<String> subject2ComboBox = new ComboBox<>();
        subject2ComboBox.getItems().addAll("Informatik", "Subject module project in Informatik", "Organisatorisk forandring og IT",
                "BANDIT", "Interactive Digital Systems");
        subject2ComboBox.setMaxWidth(Double.MAX_VALUE);

        ComboBox<String> electiveComboBox = new ComboBox<>();
        electiveComboBox.getItems().addAll("Scientific Computing", "Functional Programming and Languages", "Scientific Computing"
        );
        electiveComboBox.setMaxWidth(Double.MAX_VALUE);

        //lister til at se de fag der er blevet added.
        ListView<String> programListView = new ListView<>();

        ListView<String> subject1ListView = new ListView<>();

        ListView<String> subject2ListView = new ListView<>();

        ListView<String> electiveListView = new ListView<>();

        // Labels der viser hvor mange ects der er valgt i en given collum
        Label programNumberLabel = new Label("ECTS:");
        Label subject1NumberLabel = new Label("ECTS:");
        Label subject2NumberLabel = new Label("ECTS:");
        Label electiveNumberLabel = new Label("ECTS:");

        //labels der viser hvad der vælges i en given collum. ikke vigtigt for funktionalitet.
        Label programLabel = new Label("Program:");
        Label subject1Label = new Label("Subject 1:");
        Label subject2Label = new Label("Subject 2:");
        Label electiveLabel = new Label("Elective:");

        //knapper til at add de forskellige fag til listerne.
        Button addProgramButton = new Button("Add");
        Button addSubject1Button = new Button("Add");
        Button addSubject2Button = new Button("Add");
        Button addElectiveButton = new Button("Add");

        //gør knapperne brede for at det passer sammen med resten af programmet. ikke vigtigt for funktionalitet.
        addProgramButton.setMaxWidth(Double.MAX_VALUE);
        addSubject1Button.setMaxWidth(Double.MAX_VALUE);
        addSubject2Button.setMaxWidth(Double.MAX_VALUE);
        addElectiveButton.setMaxWidth(Double.MAX_VALUE);

        //gør at knapperne virker. henter information fra combo boksene og sætter dem ind i listerne, samt ændre ects label. der er en for hver collum
        addProgramButton.setOnAction(e -> {
            String selectedProgram = programComboBox.getSelectionModel().getSelectedItem();
            if (selectedProgram != null) {
                programListView.getItems().add(selectedProgram);
                programNumberLabel.setText("ECTS:" + getNumberForSelection(selectedProgram));
            }
        });

        addSubject1Button.setOnAction(e -> {
            String selectedSubject1 = subject1ComboBox.getSelectionModel().getSelectedItem();
            if (selectedSubject1 != null) {
                subject1ListView.getItems().add(selectedSubject1);
                subject1NumberLabel.setText("ECTS:" + getNumberForSelection(selectedSubject1));
            }
        });

        addSubject2Button.setOnAction(e -> {
            String selectedSubject2 = subject2ComboBox.getSelectionModel().getSelectedItem();
            if (selectedSubject2 != null) {
                subject2ListView.getItems().add(selectedSubject2);
                subject2NumberLabel.setText("ECTS:" + getNumberForSelection(selectedSubject2));
            }
        });

        addElectiveButton.setOnAction(e -> {
            String selectedElective = electiveComboBox.getSelectionModel().getSelectedItem();
            if (selectedElective != null) {
                electiveListView.getItems().add(selectedElective);
                electiveNumberLabel.setText("ECTS:" + getNumberForSelection(selectedElective));
            }
        });

        // tilføjer de forskellige dele i collums. delene bliver tilføjer fra toppen.
        HBox topRow = new HBox(10,
                new VBox(5,programLabel, programComboBox, addProgramButton, programListView, programNumberLabel),
                new VBox(5,subject1Label, subject1ComboBox, addSubject1Button, subject1ListView, subject1NumberLabel),
                new VBox(5, subject2Label, subject2ComboBox, addSubject2Button, subject2ListView, subject2NumberLabel),
                new VBox(5, electiveLabel, electiveComboBox, addElectiveButton, electiveListView, electiveNumberLabel)
        );

        //tilføjer det til scenen og giver lidt ekstra spacing.
        VBox mainLayout = new VBox(10, topRow);
        mainLayout.setPadding(new Insets(10));


        Scene scene = new Scene(mainLayout, 800, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // lige nu er dette måden der bliver tilføjet ECTS. dette skal nok ændres, men genbrug gerne getNumberForSelection, da denne er fobundet til labels.
    private String getNumberForSelection(String selection) {
        switch (selection) {
            case "HumTek":
                return "100";
            case "Computer Science":
                return "200";
            case "Informatik":
                return "300";
            case "Scientific Computing":
                return "400";
            default:
                return "0";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
