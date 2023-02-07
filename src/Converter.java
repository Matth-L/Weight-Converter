package src;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//yes, using "model, view , controller" is better but it's useless in such a small project
//but it is what it is 

public class Converter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Text & Label
        TextField inputToConvert = new TextField("");
        Label result = new Label("Result");
        result.setWrapText(true);

        // MenuButton
        MenuButton menu1 = new MenuButton("Choose : ");
        menu1.getItems().addAll(new MenuItem("kg"), new MenuItem("lbs"), new MenuItem("oz"));
        MenuButton menu2 = new MenuButton("Choose : ");
        menu2.getItems().addAll(new MenuItem("kg"), new MenuItem("lbs"), new MenuItem("oz"));

        // Convert Button
        Button convert = new Button("Conversion");

        /*
         * create event for each button of the menu button
         */
        for (MenuItem item : menu1.getItems()) {
            item.setOnAction(event -> {
                menu1.setText(item.getText());
            });
        }

        for (MenuItem item : menu2.getItems()) {
            item.setOnAction(event -> {
                menu2.setText(item.getText());
            });
        }

        /*
         * If button pressed :
         * create var "toConvert" with input value
         * convert it in "converted"
         * output it in the label
         */
        convert.setOnAction(event -> {
            UnitWeight toConvert = new UnitWeight(Double.parseDouble(inputToConvert.getText()));
            double converted = toConvert.convert(menu1.getText(), menu2.getText());
            result.setText(String.valueOf(converted));
        });

        /*
         * Store all button etc..
         */

        // creating and adding it to the vbox which contains all button
        HBox input = new HBox(inputToConvert);
        HBox menuButton = new HBox(menu1, menu2);
        HBox output = new HBox(convert);
        HBox resultOutput = new HBox(result);
        VBox root = new VBox(input, menuButton, output, resultOutput);

        // setting position
        input.setAlignment(Pos.CENTER);
        menuButton.setAlignment(Pos.CENTER);
        output.setAlignment(Pos.CENTER);
        resultOutput.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);
        // scene creation
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Converter");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }
}
