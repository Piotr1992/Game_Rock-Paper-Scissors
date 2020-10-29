
package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
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

public class Game {

    private Stage primaryStage;

    LimitSpinner userName = new LimitSpinner();

    NumberSpinner numberOfRounds = new NumberSpinner();

    int resultPlayerHuman = 0;
    int resultPlayerComputer = 0;

    int totalResultNumberOfRoundsHuman = 0;
    int totalResultNumberOfRoundsComputer = 0;

    int numberOfRoundsWin = 0;

    int executedMovePlayer = 0;
    int executedMoveComputer = 0;

    PlayerComputer pC = new PlayerComputer();

    String winnerRound = "";

    Button btnPaper = new Button();
    Button btnRock = new Button();
    Button btnScissors = new Button();

    Button btnCloseWindowGame = new Button();

    Button btnCloseWindowForm = new Button();

    Button btnPlayGame = new Button();

    Button btnPlayGameAgain = new Button();

    Button helpBtn = new Button();

    Stage helpStageEndGame = new Stage();

    String uN = userName.getText();

    Stage stage = new Stage();





    int counter = 0;

    Image imageIconMovePlayer = new Image(getClass().getResourceAsStream(""));
    ImageView imageViewIconMovePlayer = new ImageView(imageIconMovePlayer);

    Image imageIconMoveComputer = new Image(getClass().getResourceAsStream(""));
    ImageView imageViewIconMoveComputer = new ImageView(imageIconMoveComputer);

    Image imageIconPaper = new Image(getClass().getResourceAsStream("icons/paper.png"));
    ImageView imageViewIconPaper = new ImageView(imageIconPaper);

    Image imageIconRock = new Image(getClass().getResourceAsStream("icons/rock.png"));
    ImageView imageViewIconRock = new ImageView(imageIconRock);

    Image imageIconScissors = new Image(getClass().getResourceAsStream("icons/scissors.jpg"));
    ImageView imageViewIconScissors = new ImageView(imageIconScissors);

    Image imageIconCloseWindow = new Image(getClass().getResourceAsStream("icons/button-close.png"));
    ImageView imageViewIconCloseWindow = new ImageView(imageIconCloseWindow);

    Image imageIconPlayGame = new Image(getClass().getResourceAsStream("icons/play_again_button.png"));
    ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);

    Label currentResultsGame = new Label();

    public void playGame(String user, int WonRounds) {

//        uN = userName.getText();

        primaryStage = new Stage();

        primaryStage.setResizable(false);
//        primaryStage.initStyle(StageStyle.UNDECORATED);

//        ZeroSavedResults();

        resultPlayerHuman = 0;
        resultPlayerComputer = 0;

        totalResultNumberOfRoundsHuman = 0;
        totalResultNumberOfRoundsComputer = 0;



        counter = 1;



/*        totalResultNumberOfRoundsHuman = zeroResultsOfGame();
        totalResultNumberOfRoundsComputer = zeroResultsOfGame();        */


        Image imageIconPlayerComputer = new Image(getClass().getResourceAsStream("icons/Player-Computer.png"));
        ImageView imageViewIconPlayerComputer = new ImageView(imageIconPlayerComputer);
        imageViewIconPlayerComputer.setFitHeight(150);
        imageViewIconPlayerComputer.setFitWidth(150);
        imageViewIconPlayerComputer.setLayoutX(200);
        imageViewIconPlayerComputer.setLayoutY(50);
        HBox hboxPlayerComputer = new HBox(imageViewIconPlayerComputer);
        hboxPlayerComputer.setPadding(new Insets(15, 0, 0, 830));

        Image imageIconPlayerPerson = new Image(getClass().getResourceAsStream("icons/Player-Person.png"));
        ImageView imageViewIconPlayerPerson = new ImageView(imageIconPlayerPerson);
        imageViewIconPlayerPerson.setFitHeight(150);
        imageViewIconPlayerPerson.setFitWidth(100);
        imageViewIconPlayerPerson.setLayoutX(200);
        imageViewIconPlayerPerson.setLayoutY(50);
        HBox hboxPlayerPerson = new HBox(imageViewIconPlayerPerson);
        hboxPlayerPerson.setPadding(new Insets(15, 0, 0, 20));

        Label labelUserName = new Label();
        labelUserName.setText(uN);
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18);
        labelUserName.setFont(font);
        labelUserName.setTextFill(Color.RED);
        labelUserName.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hboxlabelUserName = new HBox(labelUserName);
        hboxlabelUserName.setPadding(new Insets(180, 0, 0, 50));

        Label labelComputer = new Label();
        labelComputer.setText("Computer");
        labelComputer.setFont(font);
        labelComputer.setTextFill(Color.RED);
        labelComputer.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hboxlabelComputer = new HBox(labelComputer);
        hboxlabelComputer.setPadding(new Insets(180, 0, 0, 870));

        Label infoMovesUser = new Label();
        infoMovesUser.setText("Below are three moves. Click one from them!");
        infoMovesUser.setFont(font);
        infoMovesUser.setTextFill(Color.RED);
        infoMovesUser.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hboxInfoMovesUser = new HBox(infoMovesUser);
        hboxInfoMovesUser.setPadding(new Insets(520, 0, 0, 40));

        imageViewIconMovePlayer.setFitWidth(300);
        imageViewIconMovePlayer.setFitHeight(300);

        imageViewIconMoveComputer.setFitWidth(300);
        imageViewIconMoveComputer.setFitHeight(300);

        btnPaper.setGraphic(imageViewIconPaper);
        imageViewIconPaper.setFitHeight(100);
        imageViewIconPaper.setFitWidth(100);

        btnRock.setGraphic(imageViewIconRock);
        imageViewIconRock.setFitHeight(100);
        imageViewIconRock.setFitWidth(100);

        btnScissors.setGraphic(imageViewIconScissors);
        imageViewIconScissors.setFitHeight(100);
        imageViewIconScissors.setFitWidth(100);

        btnCloseWindowGame.setGraphic(imageViewIconCloseWindow);
        imageViewIconCloseWindow.setFitHeight(50);
        imageViewIconCloseWindow.setFitWidth(50);

        btnPlayGameAgain.setGraphic(imageViewIconPlayGame);
        imageViewIconPlayGame.setFitHeight(50);
        imageViewIconPlayGame.setFitWidth(150);

        btnPaper.setDisable(false);
        btnRock.setDisable(false);
        btnScissors.setDisable(false);



        EventHandler<MouseEvent> eventHandlerHelpBtn = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent e) {
                //totalResultNumberOfRoundsComputer == numberOfRoundsWin
/*                currentResultsGame.setText(userName + "|||RouWin :" + numberOfRoundsWin +
                                           "\ncurrH: " + resultPlayerHuman + "|||currC :" + resultPlayerComputer +
                                            "\ntotH: " + totalResultNumberOfRoundsHuman + "totC: " + totalResultNumberOfRoundsComputer);                */

                currentResultsGame.setText(user + "|||RouWin :" + WonRounds +
                        "\ncurrH: " + resultPlayerHuman + "|||currC :" + resultPlayerComputer +
                        "\ntotH: " + totalResultNumberOfRoundsHuman + "totC: " + totalResultNumberOfRoundsComputer);

            }
        };

        helpBtn.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerHelpBtn);



        EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                //        counter = count;

                //                    ZeroSavedResults();

/*                resultPlayerHuman = 0;
                resultPlayerComputer = 0;                   */

                executedMoveComputer = pC.executeMove();

                try {

                    imageViewIconMovePlayer.setImage(imageIconPaper);
                    executedMovePlayer = 2;
                    if ( executedMoveComputer == 1 ) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerHuman = 1;
                        resultPlayerComputer = 0;
//                        SaveResults(1, 0);
                        winnerRound = uN;
                    } else if ( executedMoveComputer == 2 ) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 0;
                        winnerRound = "";
                    } else if ( executedMoveComputer == 3 ) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 1;
//                        SaveResults(0, 1);
                        winnerRound = "Computer";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

/*                if( val == 1 ) {
                    resultPlayerHuman = 0;
                    resultPlayerComputer = 0;
                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;
                }               */

//                SaveResults(resultPlayerHuman, resultPlayerComputer, 1);

/*                totalResultNumberOfRoundsHuman = returnTotalNumberOfRoundsHuman();

                totalResultNumberOfRoundsComputer = returnTotalNumberOfRoundsComputer();            */


                if( resultPlayerHuman==1 ) {
                    totalResultNumberOfRoundsHuman += 1;
                } else if( resultPlayerComputer==1 ) {
                    totalResultNumberOfRoundsComputer += 1;
                }



                if( totalResultNumberOfRoundsHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win "+uN+"!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

/*                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;              */

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( totalResultNumberOfRoundsComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

/*                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;                  */

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else {
                    currentResultsGame.setText("Current result game:\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);
                }

//                ZeroSavedResults();



                currentResultsGame.setText(user + "|||RouWin :" + WonRounds +
                        "\ncurrH: " + resultPlayerHuman + "|||currC :" + resultPlayerComputer +
                        "\ntotH: " + totalResultNumberOfRoundsHuman + "totC: " + totalResultNumberOfRoundsComputer);

                counter++;


            }
        };



        EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

//                    ZeroSavedResults();

                resultPlayerHuman = 0;
                resultPlayerComputer = 0;

                executedMoveComputer = pC.executeMove();

                try {
                    imageViewIconMovePlayer.setImage(imageIconRock);
                    executedMovePlayer = 1;
                    if (executedMoveComputer == 1) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        winnerRound = "";
                    } else if (executedMoveComputer == 2) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerComputer++;
                        winnerRound = "Computer";
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerHuman++;
                        winnerRound = uN;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

/*                if( val == 1 ) {
                    resultPlayerHuman = 0;
                    resultPlayerComputer = 0;
                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;
                }               */

//                SaveResults(resultPlayerHuman, resultPlayerComputer, 1);

/*                totalResultNumberOfRoundsHuman = returnTotalNumberOfRoundsHuman();

                totalResultNumberOfRoundsComputer = returnTotalNumberOfRoundsComputer();            */



                totalResultNumberOfRoundsHuman += resultPlayerHuman;

                totalResultNumberOfRoundsComputer += resultPlayerComputer;



                if( totalResultNumberOfRoundsHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win "+uN+"!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( totalResultNumberOfRoundsComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else {
                    currentResultsGame.setText("Current result game: \n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);
                }

//                ZeroSavedResults();


/*                currentResultsGame.setText(userName + "|||RouWin :" + numberOfRoundsWin +
                        "\ncurrH: " + resultPlayerHuman + "|||currC :" + resultPlayerComputer +
                        "\ntotH: " + returnTotalNumberOfRoundsHuman() + "totC: " + returnTotalNumberOfRoundsComputer());                */



            }
        };

        EventHandler<MouseEvent> eventHandlerScissors = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {


                resultPlayerHuman = 0;
                resultPlayerComputer = 0;

                executedMoveComputer = pC.executeMove();

                try {

                    imageViewIconMovePlayer.setImage(imageIconScissors);
                    executedMovePlayer = 3;
                    if (executedMoveComputer == 1) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerComputer++;
                        winnerRound = "Computer";
                    } else if (executedMoveComputer == 2) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerHuman++;
                        winnerRound = uN;
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        winnerRound = "";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

/*                if( val == 1 ) {
                    resultPlayerHuman = 0;
                    resultPlayerComputer = 0;
                    totalResultNumberOfRoundsHuman = 0;
                    totalResultNumberOfRoundsComputer = 0;
                }               */

//                SaveResults(resultPlayerHuman, resultPlayerComputer, 1);

/*                totalResultNumberOfRoundsHuman = returnTotalNumberOfRoundsHuman();

                totalResultNumberOfRoundsComputer = returnTotalNumberOfRoundsComputer();            */



                totalResultNumberOfRoundsHuman += resultPlayerHuman;

                totalResultNumberOfRoundsComputer += resultPlayerComputer;



                if( totalResultNumberOfRoundsHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win player "+uN+"!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( totalResultNumberOfRoundsComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);

//                    ZeroSavedResults();

                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else {
                    currentResultsGame.setText("Current result game: \n" + uN + " -> " + resultPlayerHuman + "   " + "Computer -> " + resultPlayerComputer);
                }

//                ZeroSavedResults();


/*                currentResultsGame.setText(userName + "|||RouWin :" + numberOfRoundsWin +
                        "\ncurrH: " + resultPlayerHuman + "|||currC :" + resultPlayerComputer +
                        "\ntotH: " + returnTotalNumberOfRoundsHuman() + "totC: " + returnTotalNumberOfRoundsComputer());                    */


            }
        };

        EventHandler<MouseEvent> eventHandlerPlayGameAgain = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                    btnCloseWindowGame.setDisable(true);
                    btnPlayGameAgain.setDisable(true);
//                    val = playGameAgain();

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        EventHandler<MouseEvent> eventHandlerCloseWindow = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                    btnCloseWindowGame.setDisable(true);
                    btnPlayGameAgain.setDisable(true);
//                    endGame();
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPaper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPaper);
        btnRock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRock);
        btnScissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerScissors);
        btnCloseWindowGame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCloseWindow);
        btnPlayGameAgain.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPlayGameAgain);

        HBox hboxButtons = new HBox(btnPaper, btnRock, btnScissors);
        hboxButtons.setSpacing(5);
        hboxButtons.setPadding(new Insets(550, 0, 0, 30));

        HBox hboxClosePlaybtns = new HBox(btnCloseWindowGame, btnPlayGameAgain, helpBtn);
        hboxClosePlaybtns.setSpacing(50);
        hboxClosePlaybtns.setPadding(new Insets(10, 0, 0, 350));

        StackPane spButtonsMove = new StackPane();
        spButtonsMove.getChildren().add(hboxButtons);
        spButtonsMove.setPadding(new Insets(550, 0, 0, 30));
        spButtonsMove.setTranslateX(50);
        spButtonsMove.setTranslateY(50);

        StackPane spButtonsClosePlay = new StackPane();
        spButtonsClosePlay.getChildren().add(hboxClosePlaybtns);
        spButtonsClosePlay.setPadding(new Insets(10, 0, 0, 350));

        Group firstGroup = new Group();
        firstGroup.getChildren().add(hboxButtons);
        firstGroup.setTranslateX(-310);
        firstGroup.setTranslateY(-10);

        Group sceondGroup = new Group();
        sceondGroup.getChildren().add(hboxClosePlaybtns);
        sceondGroup.setTranslateX(-200);
        sceondGroup.setTranslateY(-300);

        HBox hboxRect = new HBox(imageViewIconMovePlayer, imageViewIconMoveComputer);
        hboxRect.setPadding(new Insets(175, 0, 0, 150));
        hboxRect.setSpacing(50);

        Font fontResultGame = Font.font("Arial Black", FontWeight.BOLD, FontPosture.ITALIC, 30);
        currentResultsGame.setFont(fontResultGame);
        currentResultsGame.setTextFill(Color.RED);
        currentResultsGame.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        currentResultsGame.setText("Player " + uN + " ever execute \nfirst move!");
        HBox hboxCurrentResultsGame = new HBox(currentResultsGame);
        hboxCurrentResultsGame.setPadding(new Insets(550, 50, 0, 450));
        hboxCurrentResultsGame.setFillHeight(true);

        StackPane root = new StackPane();

        root.getChildren().add(hboxRect);
        root.getChildren().add(hboxPlayerComputer);
        root.getChildren().add(hboxPlayerPerson);
        root.getChildren().add(hboxInfoMovesUser);
        root.getChildren().add(hboxlabelUserName);
        root.getChildren().add(hboxlabelComputer);
        root.getChildren().add(hboxCurrentResultsGame);
        root.getChildren().add(firstGroup);
        root.getChildren().add(sceondGroup);

        root.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        Scene scene = new Scene(root,1000,700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }





    public void endGame() {

        helpStageEndGame.setResizable(false);
//        helpStageEndGame.initStyle(StageStyle.UNDECORATED);

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

                    //ZeroSavedResults();

                    helpStageEndGame.close();
                    //primaryStage.close();
                    stage.close();

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

                    btnPlayGame.setDisable(false);
                    btnCloseWindowForm.setDisable(false);
                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);
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
