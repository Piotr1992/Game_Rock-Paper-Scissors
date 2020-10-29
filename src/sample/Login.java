
package sample;

import javafx.application.Platform;
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
import javafx.stage.StageStyle;

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

    Stage helpStageEndGame = new Stage();

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
        stage.setOnCloseRequest(e -> Platform.exit());

        root.setAlignment(Pos.CENTER);

        userName.setText();

        stage.setResizable(false);

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

        Game g = new Game();

        stage.initStyle(StageStyle.UNDECORATED);

        helpStageEndGame.initStyle(StageStyle.UNDECORATED);

        EventHandler<MouseEvent> eventHandlerPlayGame = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                uN = userName.getText();
                numberOfRoundsWin = numberOfRounds.getNumber().intValue();

                try {
                    if( !uN.equals("") && numberOfRoundsWin > 0 && numberOfRoundsWin < 100 ) {
                        g.playGame(uN, numberOfRoundsWin);
                        stage.close();
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
                    endLogin(numberOfRoundsWin);
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

    public void endLogin(int wonRounds) {
        helpStageEndGame.setOnCloseRequest(e -> Platform.exit());

        helpStageEndGame.setResizable(false);

        StackPane root = new StackPane();

        Scene scene = new Scene(root,400,150);

        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(25), Insets.EMPTY)));

        Label labelAsk = new Label();
        labelAsk.setText("Are you sure you want to end the game?");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18);
        labelAsk.setFont(font);
        labelAsk.setTextFill(Color.RED);
        labelAsk.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        Button btnYes = new Button();
        Image imageIconYes = new Image(getClass().getResourceAsStream("icons/button-yes.png"));
        ImageView imageViewIconYes = new ImageView(imageIconYes);
        btnYes.setGraphic(imageViewIconYes);
        imageViewIconYes.setFitHeight(50);
        imageViewIconYes.setFitWidth(50);

        Button btnNo = new Button();
        Image imageIconNo = new Image(getClass().getResourceAsStream("icons/button-no.png"));
        ImageView imageViewIconNo = new ImageView(imageIconNo);
        btnNo.setGraphic(imageViewIconNo);
        imageViewIconNo.setFitHeight(50);
        imageViewIconNo.setFitWidth(50);

        HBox hBoxlabelAsk = new HBox(labelAsk);
        HBox hBoxbtns = new HBox(btnYes, btnNo);
        hBoxlabelAsk.setPadding(new Insets(25, 0, 0, 45));
        hBoxbtns.setSpacing(50);
        hBoxbtns.setPadding(new Insets(75, 0, 0, 100));

        EventHandler<MouseEvent> eventHandlerYes = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    stage.close();
                    helpStageEndGame.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        btnYes.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerYes);

        EventHandler<MouseEvent> eventHandlerNo = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnPlayGame.setDisable(false);
                    btnCloseWindowForm.setDisable(false);
                    helpStageEndGame.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        btnNo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNo);

        root.getChildren().add(hBoxlabelAsk);
        root.getChildren().add(hBoxbtns);

        helpStageEndGame.setScene(scene);
        helpStageEndGame.show();

    }

}
