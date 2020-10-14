package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.text.Element;
import javax.swing.text.html.*;
import java.io.FileInputStream;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            // set title
            primaryStage.setTitle("New Button and its Action Listener");
            // create a new Button shape
            Button btn = new Button();
            Label lb = new Label();
            // set text inside button
            btn.setText("Display Message");
            lb.setText("John has a cat.");

            FileInputStream inputFileIconPlayerComputer = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\Player-Computer.png");
            Image imageIconPlayerComputer = new Image(inputFileIconPlayerComputer);
            ImageView imageViewIconPlayerComputer = new ImageView(imageIconPlayerComputer);
            imageViewIconPlayerComputer.setFitHeight(100);
            imageViewIconPlayerComputer.setFitWidth(100);
            imageViewIconPlayerComputer.setLayoutX(200);
            imageViewIconPlayerComputer.setLayoutY(50);
            HBox hbox = new HBox(imageViewIconPlayerComputer);

            hbox.setPadding(new Insets(100, 0, 0, 590));

            //Scene scene2 = new Scene(hbox, 200, 100);

            //primaryStage.setScene(scene2);

            lb.setMaxWidth(Double.POSITIVE_INFINITY);
            lb.setMaxHeight(Double.POSITIVE_INFINITY);
            lb.setStyle("-fx-border-color: blue;");


            btn.setOnAction((ActionEvent a) -> lb.setText("Alice has a dog."));

            // stack pane
            StackPane root = new StackPane();

            // add button to Stack Pane
            root.getChildren().add(btn);
            root.getChildren().add(lb);
            root.getChildren().add(hbox);

            Scene scene = new Scene(root,700,700);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
