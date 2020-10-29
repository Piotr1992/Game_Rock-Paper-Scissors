package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login {

    StackPane root = new StackPane();

    Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 30);

    Label label = new Label("Fill in the data below!");

    Font fontUserNameNumber = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);

    Label labelUserName = new Label("Input your name:");

    Label labelNumber = new Label("Input number won rounds from range [1 - 99]:");

    Image imageIconPlayGame = new Image( getClass().getResourceAsStream("icons/button-play.png") );

    ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);

    Image imageIconCloseWindow = new Image(getClass().getResourceAsStream("icons/button-close.png"));

    ImageView imageViewIconCloseWindow = new ImageView(imageIconCloseWindow);

    LimitSpinner userName = new LimitSpinner();

    NumberSpinner numberOfRounds = new NumberSpinner();

    Stage stage = new Stage();

    Button btnPlayGame = new Button();

    Button btnCloseWindowForm = new Button();

    String uN = "";

    int numberOfRoundsWin = 0;

    HBox hboxUserName = new HBox(labelUserName, userName);
    HBox hboxNumber = new HBox(labelNumber, numberOfRounds);
    HBox hboxPlayClosebtns = new HBox(btnPlayGame, btnCloseWindowForm);
    VBox box = new VBox();
    Scene scene = new Scene(box, 400, 400);

    public void showLoginScreen() {

//        ZeroSavedResults();

        root.setAlignment(Pos.CENTER);

        userName.setText();

        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);

        label.setFont(font);
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        labelUserName.setFont(fontUserNameNumber);
        labelUserName.setTextFill(Color.RED);
        labelUserName.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        labelNumber.setFont(fontUserNameNumber);
        labelNumber.setTextFill(Color.RED);
        labelNumber.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        imageViewIconPlayGame.setFitHeight(50);
        imageViewIconPlayGame.setFitWidth(100);
        btnPlayGame.setGraphic(imageViewIconPlayGame);

        btnCloseWindowForm.setGraphic(imageViewIconCloseWindow);
        imageViewIconCloseWindow.setFitHeight(50);
        imageViewIconCloseWindow.setFitWidth(50);

        EventHandler<MouseEvent> eventHandlerPlayGame = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    if( !userName.getText().equals("") && numberOfRounds.getNumber().intValue() > 0 && numberOfRounds.getNumber().intValue() < 100 ) {
                        stage.close();

                        uN = userName.getText();
                        numberOfRoundsWin = numberOfRounds.getNumber().intValue();

                        Game g = new Game();

                        g.playGame(uN, numberOfRoundsWin);

                    }
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPlayGame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPlayGame);

        EventHandler<MouseEvent> eventHandlerCloseWindow = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnPlayGame.setDisable(true);
                    btnCloseWindowForm.setDisable(true);
//                    endGame();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnCloseWindowForm.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCloseWindow);

        hboxUserName.setSpacing(30);
        hboxUserName.setPadding(new Insets(10, 0, 0, 10));

        hboxNumber.setSpacing(30);
        hboxNumber.setPadding(new Insets(10, 0, 0, 10));

        hboxPlayClosebtns.setSpacing(100);
        hboxPlayClosebtns.setPadding(new Insets(10, 0, 0, 50));

        box.setPadding(new Insets(10));

        box.setAlignment(Pos.CENTER);

        box.setSpacing(30);

        box.getChildren().add(label);
        box.getChildren().add(hboxUserName);
        box.getChildren().add(hboxNumber);
        box.getChildren().add(hboxPlayClosebtns);

        stage.setScene(scene);

        box.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        stage.show();

    }

}
