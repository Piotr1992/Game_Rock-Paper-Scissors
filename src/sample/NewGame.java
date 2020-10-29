package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class NewGame {

    Stage helpStageGameAgain = new Stage();

    Stage stage = new Stage();

    Button btnCloseWindowGame = new Button();

    Button btnPlayGameAgain = new Button();

    NumberSpinner numberOfRounds = new NumberSpinner();

    int resultPlayerHuman = 0;
    int resultPlayerComputer = 0;

    Button btnPaper = new Button();
    Button btnRock = new Button();
    Button btnScissors = new Button();


    public void playGameAgain() {

        helpStageGameAgain.setResizable(false);
//        helpStageGameAgain.initStyle(StageStyle.UNDECORATED);

        StackPane root = new StackPane();

        Scene scene = new Scene(root,400,150);

        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(25), Insets.EMPTY)));

        Label labelAsk = new Label();
        labelAsk.setText("Are you sure you want to end the current game?");
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
        hBoxlabelAsk.setPadding(new Insets(25, 0, 0, 15));
        hBoxbtns.setSpacing(50);
        hBoxbtns.setPadding(new Insets(75, 0, 0, 100));

        EventHandler<MouseEvent> eventHandlerYes = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {

/*                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;              */

                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);

//                    counter = 1;

                    helpStageGameAgain.close();
                    stage.close();
                    //primaryStage.close();

                    Stage renewStage = new Stage();

                    Main m = new Main();

                    m.start(renewStage);

//                    value = 1;

                    //showLoginScreen();

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

                    if( ( numberOfRounds.getNumber().intValue() != resultPlayerHuman ) && ( numberOfRounds.getNumber().intValue() != resultPlayerComputer ) )
                    {
                        btnPaper.setDisable(false);
                        btnRock.setDisable(false);
                        btnScissors.setDisable(false);
                    }

                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);
                    helpStageGameAgain.close();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
        btnNo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNo);

        root.getChildren().add(hBoxlabelAsk);
        root.getChildren().add(hBoxbtns);
        helpStageGameAgain.setScene(scene);
        helpStageGameAgain.show();



    }

}
