
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
    private HelpClass hc = new HelpClass();
    private Label label = hc.setLabel(  "Fill in the data below!",  Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 30)    );
    Font font15 = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
    private Label labelUserName = hc.setLabel(  "Input your name (max 15 chars):", font15);
    private Label labelNumber = hc.setLabel(    "Input number won rounds from range [1 - 99]:", font15);
    private ImageView imageViewIconPlayGame = hc.setImageView(  new Image( getClass().getResourceAsStream("icons/button-play.png") ), 50, 100   );
    private ImageView imageViewIconCloseWindow = hc.setImageView(   new Image(getClass().getResourceAsStream("icons/button-close.png")), 50, 50    );
    private LimitSpinner userName = new LimitSpinner();
    private NumberSpinner numberOfRounds = new NumberSpinner();
    private Stage stage = new Stage();
    private Stage helpStageEndGame = new Stage();
    private Button btnPlayGame = new Button();
    private Button btnCloseWindowForm = new Button();
    private String uN = "";
    private int numberOfRoundsWin = 0;
    private VBox box = new VBox();
    private Scene scene = new Scene(box, 400, 400);
    private HBox hboxUserName = hc.setHBox(new HBox(labelUserName, userName), 30, 10, 0, 0, 10);
    private HBox hboxNumber = hc.setHBox(new HBox(labelNumber, numberOfRounds), 30, 10, 0, 0, 10);
    HBox hboxPlayClosebtns = hc.setHBox(new HBox(btnPlayGame, btnCloseWindowForm), 100, 10, 0, 0, 50);
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
                    hc.showMessage(stage, helpStageEndGame, btnPlayGame, btnCloseWindowForm, null, null, null, null, null,
                            numberOfRoundsWin,"Are you sure you want to end the game?", 1,0,  0);
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
        box.getChildren().add(hboxUserName);
        box.getChildren().add(hboxNumber);
        box.getChildren().add(hboxPlayClosebtns);
        box.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));
        stage = hc.setStage(scene, stage);
    }
}
