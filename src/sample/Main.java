
package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {

            FileInputStream inputFileIconPlayerComputer = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\Player-Computer.png");
            Image imageIconPlayerComputer = new Image(inputFileIconPlayerComputer);
            ImageView imageViewIconPlayerComputer = new ImageView(imageIconPlayerComputer);
            imageViewIconPlayerComputer.setFitHeight(100);
            imageViewIconPlayerComputer.setFitWidth(100);
            imageViewIconPlayerComputer.setLayoutX(200);
            imageViewIconPlayerComputer.setLayoutY(50);
            HBox hboxPlayerComputer = new HBox(imageViewIconPlayerComputer);
            hboxPlayerComputer.setPadding(new Insets(10, 0, 0, 590));

            FileInputStream inputFileIconPlayerPerson = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\Player-Person.png");
            Image imageIconPlayerPerson = new Image(inputFileIconPlayerPerson);
            ImageView imageViewIconPlayerPerson = new ImageView(imageIconPlayerPerson);
            imageViewIconPlayerPerson.setFitHeight(100);
            imageViewIconPlayerPerson.setFitWidth(100);
            imageViewIconPlayerPerson.setLayoutX(200);
            imageViewIconPlayerPerson.setLayoutY(50);
            HBox hboxPlayerPerson = new HBox(imageViewIconPlayerPerson);
            hboxPlayerPerson.setPadding(new Insets(10, 0, 0, 10));

            Label infoMovesUser = new Label();
            infoMovesUser.setText("Below are three moves.Click one from them!");
            Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
            infoMovesUser.setFont(font);
            infoMovesUser.setTextFill(Color.RED);
            infoMovesUser.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
            HBox hboxInfoMovesUser = new HBox(infoMovesUser);
            hboxInfoMovesUser.setPadding(new Insets(330, 0, 0, 10));

            FileInputStream inputFileIconPaper = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\paper.png");
            Button btnPaper = new Button();
            Image imageIconPaper = new Image(inputFileIconPaper);
            ImageView imageViewIconPaper = new ImageView(imageIconPaper);
            btnPaper.setGraphic(imageViewIconPaper);
            imageViewIconPaper.setFitHeight(100);
            imageViewIconPaper.setFitWidth(100);

            StackPane root = new StackPane();

            EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        Image i = new Image(new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\paper.png"));
                        ImageView IV = new ImageView(i);
                        IV.setFitHeight(200);
                        IV.setFitWidth(200);
                        HBox hboxIV = new HBox(IV);
                        hboxIV.setPadding(new Insets(75, 0, 0, 125));
                        root.getChildren().add(hboxIV);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            btnPaper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPaper);

            FileInputStream inputFileIconRock = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\rock.png");
            Button btnRock = new Button();
            Image imageIconRock = new Image(inputFileIconRock);
            ImageView imageViewIconRock = new ImageView(imageIconRock);
            btnRock.setGraphic(imageViewIconRock);
            imageViewIconRock.setFitHeight(100);
            imageViewIconRock.setFitWidth(100);

            EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        Image i = new Image(new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\rock.png"));
                        ImageView IV = new ImageView(i);
                        IV.setFitHeight(200);
                        IV.setFitWidth(200);
                        HBox hboxIV = new HBox(IV);
                        hboxIV.setPadding(new Insets(75, 0, 0, 125));
                        root.getChildren().add(hboxIV);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            btnRock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRock);

            FileInputStream inputFileIconScissors = new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\scissors.jpg");
            Button btnScissors = new Button();
            Image imageIconScissors = new Image(inputFileIconScissors);
            ImageView imageViewIconScissors = new ImageView(imageIconScissors);
            btnScissors.setGraphic(imageViewIconScissors);
            imageViewIconScissors.setFitHeight(100);
            imageViewIconScissors.setFitWidth(100);

            EventHandler<MouseEvent> eventHandlerScissors = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        Image i = new Image(new FileInputStream("C:\\Users\\Lenovo\\IntelliJDEAProjects\\Game_Rock-Paper-Scissors\\src\\sample\\icons\\scissors.jpg"));
                        ImageView IV = new ImageView(i);
                        IV.setFitHeight(200);
                        IV.setFitWidth(200);
                        HBox hboxIV = new HBox(IV);
                        hboxIV.setPadding(new Insets(75, 0, 0, 125));
                        root.getChildren().add(hboxIV);
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            btnScissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerScissors);

            HBox hboxbuttons = new HBox(btnPaper, btnRock, btnScissors);
            hboxbuttons.setSpacing(5);
            hboxbuttons.setPadding(new Insets(350, 0, 0, 10));

            root.getChildren().add(hboxPlayerComputer);
            root.getChildren().add(hboxPlayerPerson);
            root.getChildren().add(hboxInfoMovesUser);
            root.getChildren().add(hboxbuttons);

            root.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

            Scene scene = new Scene(root,700,700);
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
