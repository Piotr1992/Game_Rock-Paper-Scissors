
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
import javafx.stage.StageStyle;

public class Login {
    HelpClass hc = new HelpClass();

    Label label = hc.setLabel(  "Fill in the data below!",  Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 30)    );
    Label labelUserName = hc.setLabel(  "Input your name:",     Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15)   );
    Label labelNumber = hc.setLabel(    "Input number won rounds from range [1 - 99]:",     Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15)    );

    ImageView imageViewIconPlayGame = hc.setImageView(  new Image( getClass().getResourceAsStream("icons/button-play.png") ), 50, 100   );
    ImageView imageViewIconCloseWindow = hc.setImageView(   new Image(getClass().getResourceAsStream("icons/button-close.png")), 50, 50    );

    LimitSpinner userName = new LimitSpinner();

    NumberSpinner numberOfRounds = new NumberSpinner();

    Stage stage = new Stage();

    Stage helpStageEndGame = new Stage();

    Button btnPlayGame = new Button();

    Button btnCloseWindowForm = new Button();

    String uN = "";

    int numberOfRoundsWin = 0;

    VBox box = new VBox();

    Scene scene = new Scene(box, 400, 400);

    public void showLoginScreen() {

        userName.setText();

        btnPlayGame.setGraphic(imageViewIconPlayGame);

        btnCloseWindowForm.setGraphic(imageViewIconCloseWindow);

        Game g = new Game();

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

        box.setPadding(new Insets(10));

        box.setAlignment(Pos.CENTER);

        box.setSpacing(30);

        box.getChildren().add(label);
        box.getChildren().add( hc.setHBox( new HBox(labelUserName, userName), 30, 10, 0, 0, 10 ) );
        box.getChildren().add( hc.setHBox( new HBox(labelNumber, numberOfRounds), 30, 10, 0, 0, 10 ) );
        box.getChildren().add( hc.setHBox( new HBox(btnPlayGame, btnCloseWindowForm), 100, 10, 0, 0, 50 ) );

        box.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        stage = hc.setStage(scene, stage);

    }

    public void endLogin(int wonRounds) {

        StackPane root = new StackPane();
        Scene scene = new Scene(root,400,150);
        root = hc.showWindowBtnYesNo(root);

        Label labelAsk = hc.setLabel(  "Are you sure you want to end the game?",  Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18)    );

        Button btnYes = new Button();
        btnYes = hc.setButton(btnYes, hc.setImageView(   new Image(getClass().getResourceAsStream("icons/button-yes.png")), 50, 50    ));

        Button btnNo = new Button();
        btnNo = hc.setButton(btnNo, hc.setImageView(   new Image(getClass().getResourceAsStream("icons/button-no.png")), 50, 50    ));

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

        root.getChildren().add( hc.setHBox( new HBox(labelAsk), 0, 25, 0, 0, 45 ) );

        root.getChildren().add( hc.setHBox( new HBox(btnYes, btnNo), 50, 75, 0, 0, 100 ) );

        helpStageEndGame = hc.setHelpStage(scene, helpStageEndGame);
    }

}
