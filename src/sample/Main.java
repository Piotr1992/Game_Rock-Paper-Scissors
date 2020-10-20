
package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

            showLoginScreen();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoginScreen() {

        Stage stage = new Stage();

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        stage.setResizable(false);

        Label label = new Label("Input data.");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
        label.setFont(font);
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        TextField userName = new TextField();
        userName.setPromptText("Input your name: ");
        TextField numberOfRounds = new TextField();
        numberOfRounds.setPromptText("Input number of rounds: ");

        Button btnPlayGame = new Button();
        //btnPlayGame.setText("Play");
        Image imageIconPlayGame = new Image( getClass().getResourceAsStream("\\icons\\button-play.png") );
        ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);
        imageViewIconPlayGame.setFitHeight(25);
        imageViewIconPlayGame.setFitWidth(50);
        btnPlayGame.setGraphic(imageViewIconPlayGame);

        EventHandler<MouseEvent> eventHandlerLogin2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    stage.close();
                    playGame();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPlayGame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerLogin2);

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        box.setAlignment(Pos.CENTER);

        box.setSpacing(30);

        box.getChildren().add(label);
        box.getChildren().add(userName);
        box.getChildren().add(numberOfRounds);
        box.getChildren().add(btnPlayGame);
        Scene scene = new Scene(box, 300, 200);
        stage.setScene(scene);

        box.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        stage.show();

    }



    public void playGame() {

        Stage primaryStage = new Stage();

        Image imageIconPlayerComputer = new Image( getClass().getResourceAsStream("\\icons\\Player-Computer.png") );
        ImageView imageViewIconPlayerComputer = new ImageView(imageIconPlayerComputer);
        imageViewIconPlayerComputer.setFitHeight(150);
        imageViewIconPlayerComputer.setFitWidth(150);
        imageViewIconPlayerComputer.setLayoutX(200);
        imageViewIconPlayerComputer.setLayoutY(50);
        HBox hboxPlayerComputer = new HBox(imageViewIconPlayerComputer);
        hboxPlayerComputer.setPadding(new Insets(15, 0, 0, 530));

        Image imageIconPlayerPerson = new Image( getClass().getResourceAsStream("\\icons\\Player-Person.png") );
        ImageView imageViewIconPlayerPerson = new ImageView(imageIconPlayerPerson);
        imageViewIconPlayerPerson.setFitHeight(150);
        imageViewIconPlayerPerson.setFitWidth(100);
        imageViewIconPlayerPerson.setLayoutX(200);
        imageViewIconPlayerPerson.setLayoutY(50);
        HBox hboxPlayerPerson = new HBox(imageViewIconPlayerPerson);
        hboxPlayerPerson.setPadding(new Insets(15, 0, 0, 20));

        Label infoMovesUser = new Label();
        infoMovesUser.setText("Below are three moves. Click one from them!");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
        infoMovesUser.setFont(font);
        infoMovesUser.setTextFill(Color.RED);
        infoMovesUser.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hboxInfoMovesUser = new HBox(infoMovesUser);
        hboxInfoMovesUser.setPadding(new Insets(330, 0, 0, 10));

        Button btnPaper = new Button();
        Image imageIconPaper = new Image( getClass().getResourceAsStream("\\icons\\paper.png") );
        ImageView imageViewIconPaper = new ImageView(imageIconPaper);
        btnPaper.setGraphic(imageViewIconPaper);
        imageViewIconPaper.setFitHeight(100);
        imageViewIconPaper.setFitWidth(100);

        StackPane root = new StackPane();

        Image imageIcon = new Image( getClass().getResourceAsStream("") );
        ImageView imageViewIcon = new ImageView(imageIcon);
        imageViewIcon.setFitWidth(200);
        imageViewIcon.setFitHeight(200);

        EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    Image imagePaper = new Image( getClass().getResourceAsStream("\\icons\\paper.png") );
                    ImageView imageViewPaper = new ImageView(imagePaper);
                    imageViewPaper.setFitHeight(200);
                    imageViewPaper.setFitWidth(200);
                    imageViewIcon.setImage(imagePaper);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPaper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPaper);

        Button btnRock = new Button();
        Image imageIconRock = new Image( getClass().getResourceAsStream("\\icons\\rock.png") );
        ImageView imageViewIconRock = new ImageView(imageIconRock);
        btnRock.setGraphic(imageViewIconRock);
        imageViewIconRock.setFitHeight(100);
        imageViewIconRock.setFitWidth(100);

        EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    Image imageRock = new Image( getClass().getResourceAsStream("\\icons\\rock.png") );
                    ImageView imageViewRock = new ImageView(imageRock);
                    imageViewRock.setFitHeight(200);
                    imageViewRock.setFitWidth(200);
                    imageViewIcon.setImage(imageRock);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnRock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRock);

        Button btnScissors = new Button();
        Image imageIconScissors = new Image( getClass().getResourceAsStream("\\icons\\scissors.jpg") );
        ImageView imageViewIconScissors = new ImageView(imageIconScissors);
        btnScissors.setGraphic(imageViewIconScissors);
        imageViewIconScissors.setFitHeight(100);
        imageViewIconScissors.setFitWidth(100);

        EventHandler<MouseEvent> eventHandlerScissors = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    Image imageScissors = new Image( getClass().getResourceAsStream("\\icons\\scissors.jpg") );
                    ImageView imageViewScissors = new ImageView(imageScissors);
                    imageViewScissors.setFitHeight(200);
                    imageViewScissors.setFitWidth(200);
                    imageViewIcon.setImage(imageScissors);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnScissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerScissors);

        HBox hboxbuttons = new HBox(btnPaper, btnRock, btnScissors);
        hboxbuttons.setSpacing(5);
        hboxbuttons.setPadding(new Insets(350, 0, 0, 10));

        HBox hboxRect = new HBox(imageViewIcon);
        hboxRect.setPadding(new Insets(100, 0, 0, 130));

        root.getChildren().add(hboxRect);
        root.getChildren().add(hboxPlayerComputer);
        root.getChildren().add(hboxPlayerPerson);
        root.getChildren().add(hboxInfoMovesUser);
        root.getChildren().add(hboxbuttons);

        root.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        Scene scene = new Scene(root,700,700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
