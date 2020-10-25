
package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
//import javafx.stage.StageStyle;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

            showLoginScreen();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    Stage stage = new Stage();
    Button btnPlayGame = new Button();
    Button btnCloseWindowForm = new Button();
    TextField userName = new TextField();
    NumberSpinner numberOfRounds = new NumberSpinner();



    public void showLoginScreen() {

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        stage.setResizable(false);
//        stage.initStyle(StageStyle.UNDECORATED);

        Label label = new Label("Input below data!");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 30);
        label.setFont(font);
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        Label labelNumber = new Label("Input number from range [1 - 99]:");
        Font fontNumber = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
        labelNumber.setFont(fontNumber);
        labelNumber.setTextFill(Color.RED);
        labelNumber.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        userName.setPadding(new Insets(10, 10, 10, 10));
        //userName.setText("");
        userName.setPromptText("Input your name!");

//        numberOfRounds.setNumber();
//        numberOfRounds.setPromptText("Input number from range [1 - 99]!");

        Image imageIconPlayGame = new Image( getClass().getResourceAsStream("\\icons\\button-play.png") );
        ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);
        imageViewIconPlayGame.setFitHeight(50);
        imageViewIconPlayGame.setFitWidth(100);
        btnPlayGame.setGraphic(imageViewIconPlayGame);

        Image imageIconCloseWindow = new Image(getClass().getResourceAsStream("\\icons\\button-close.png"));
        ImageView imageViewIconCloseWindow = new ImageView(imageIconCloseWindow);
        btnCloseWindowForm.setGraphic(imageViewIconCloseWindow);
        imageViewIconCloseWindow.setFitHeight(50);
        imageViewIconCloseWindow.setFitWidth(50);

        EventHandler<MouseEvent> eventHandlerPlayGame = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    if( !userName.getText().equals("") && numberOfRounds.getNumber().intValue() > 0 && numberOfRounds.getNumber().intValue() < 100 ) {
                        stage.close();
                        playGame(userName.getText(), numberOfRounds.getNumber().intValue());
                    }
                } catch(NumberFormatException ex) {
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
                    endGame();
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnCloseWindowForm.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCloseWindow);

        HBox hboxPlayClosebtns = new HBox(btnPlayGame, btnCloseWindowForm);
        hboxPlayClosebtns.setSpacing(50);
        hboxPlayClosebtns.setPadding(new Insets(10, 0, 0, 50));

        HBox hboxNumber = new HBox(labelNumber, numberOfRounds);
        hboxNumber.setSpacing(30);
        hboxNumber.setPadding(new Insets(10, 0, 0, 10));

        VBox box = new VBox();
        box.setPadding(new Insets(10));

        box.setAlignment(Pos.CENTER);

        box.setSpacing(30);

        box.getChildren().add(label);
        box.getChildren().add(userName);
        box.getChildren().add(hboxNumber);
        box.getChildren().add(hboxPlayClosebtns);
        Scene scene = new Scene(box, 325, 325);
        stage.setScene(scene);

        box.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        stage.show();

    }



    Stage primaryStage = new Stage();

    int executedMovePlayer = 0;
    int resultPlayerHuman = 0;
    int resultPlayerComputer = 0;
    int executedMoveComputer = 0;

    PlayerComputer pC = new PlayerComputer();

    int resultTotalNumberOfRoundsHuman = 0;
    int resultTotalNumberOfRoundsComputer = 0;

    String winnerRound = "";

    Button btnCloseWindowGame = new Button();
    Button btnPlayGameAgain = new Button();

    public void playGame(String userName, int numberOfRoundsWin) {

        primaryStage.setResizable(false);
//        primaryStage.initStyle(StageStyle.UNDECORATED);

        Image imageIconPlayerComputer = new Image(getClass().getResourceAsStream("\\icons\\Player-Computer.png"));
        ImageView imageViewIconPlayerComputer = new ImageView(imageIconPlayerComputer);
        imageViewIconPlayerComputer.setFitHeight(150);
        imageViewIconPlayerComputer.setFitWidth(150);
        imageViewIconPlayerComputer.setLayoutX(200);
        imageViewIconPlayerComputer.setLayoutY(50);
        HBox hboxPlayerComputer = new HBox(imageViewIconPlayerComputer);
        hboxPlayerComputer.setPadding(new Insets(15, 0, 0, 830));

        Image imageIconPlayerPerson = new Image(getClass().getResourceAsStream("\\icons\\Player-Person.png"));
        ImageView imageViewIconPlayerPerson = new ImageView(imageIconPlayerPerson);
        imageViewIconPlayerPerson.setFitHeight(150);
        imageViewIconPlayerPerson.setFitWidth(100);
        imageViewIconPlayerPerson.setLayoutX(200);
        imageViewIconPlayerPerson.setLayoutY(50);
        HBox hboxPlayerPerson = new HBox(imageViewIconPlayerPerson);
        hboxPlayerPerson.setPadding(new Insets(15, 0, 0, 20));

        Label labelUserName = new Label();
        labelUserName.setText(userName);
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

        Button btnPaper = new Button();
        Image imageIconPaper = new Image(getClass().getResourceAsStream("\\icons\\paper.png"));
        ImageView imageViewIconPaper = new ImageView(imageIconPaper);
        btnPaper.setGraphic(imageViewIconPaper);
        imageViewIconPaper.setFitHeight(100);
        imageViewIconPaper.setFitWidth(100);

        Image imageIconMovePlayer = new Image(getClass().getResourceAsStream(""));
        ImageView imageViewIconMovePlayer = new ImageView(imageIconMovePlayer);
        imageViewIconMovePlayer.setFitWidth(300);
        imageViewIconMovePlayer.setFitHeight(300);

        Image imageIconMoveComputer = new Image(getClass().getResourceAsStream(""));
        ImageView imageViewIconMoveComputer = new ImageView(imageIconMoveComputer);
        imageViewIconMoveComputer.setFitWidth(300);
        imageViewIconMoveComputer.setFitHeight(300);

        Button btnRock = new Button();
        Image imageIconRock = new Image(getClass().getResourceAsStream("\\icons\\rock.png"));
        ImageView imageViewIconRock = new ImageView(imageIconRock);
        btnRock.setGraphic(imageViewIconRock);
        imageViewIconRock.setFitHeight(100);
        imageViewIconRock.setFitWidth(100);

        Button btnScissors = new Button();
        Image imageIconScissors = new Image(getClass().getResourceAsStream("\\icons\\scissors.jpg"));
        ImageView imageViewIconScissors = new ImageView(imageIconScissors);
        btnScissors.setGraphic(imageViewIconScissors);
        imageViewIconScissors.setFitHeight(100);
        imageViewIconScissors.setFitWidth(100);

        //Button btnCloseWindow = new Button();
        Image imageIconCloseWindow = new Image(getClass().getResourceAsStream("\\icons\\button-close.png"));
        ImageView imageViewIconCloseWindow = new ImageView(imageIconCloseWindow);
        btnCloseWindowGame.setGraphic(imageViewIconCloseWindow);
        imageViewIconCloseWindow.setFitHeight(50);
        imageViewIconCloseWindow.setFitWidth(50);

        Image imageIconPlayGame = new Image(getClass().getResourceAsStream("\\icons\\play_again_button.png"));
        ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);
        btnPlayGameAgain.setGraphic(imageViewIconPlayGame);
        imageViewIconPlayGame.setFitHeight(50);
        imageViewIconPlayGame.setFitWidth(150);

        Label currentResultsGame = new Label();

        EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

                resultPlayerHuman = 0;
                resultPlayerComputer = 0;

                executedMoveComputer = pC.executeMove();

                try {
                    imageViewIconMovePlayer.setImage(imageIconPaper);
                    executedMovePlayer = 2;
                    if (executedMoveComputer == 1) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerHuman++;
                        winnerRound = userName;
                    } else if (executedMoveComputer == 2) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        winnerRound = "";
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerComputer++;
                        winnerRound = "Computer";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                SaveResults(resultPlayerHuman, resultPlayerComputer);

                resultPlayerHuman = returnTotalNumberOfRoundsHuman();

                resultPlayerComputer = returnTotalNumberOfRoundsComputer();

                currentResultsGame.setText("Current result game:\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);

                if( resultPlayerHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win "+userName+"!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( resultPlayerComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                }
            }
        };

        EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {

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
                        winnerRound = userName;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                SaveResults(resultPlayerHuman, resultPlayerComputer);

                resultPlayerHuman = returnTotalNumberOfRoundsHuman();

                resultPlayerComputer = returnTotalNumberOfRoundsComputer();

                currentResultsGame.setText("Current result game: \n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);

                if( resultPlayerHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win "+userName+"!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( resultPlayerComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                }
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
                        winnerRound = userName;
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        winnerRound = "";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                SaveResults(resultPlayerHuman, resultPlayerComputer);

                resultPlayerHuman = returnTotalNumberOfRoundsHuman();

                resultPlayerComputer = returnTotalNumberOfRoundsComputer();

                currentResultsGame.setText("Current result game: \n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);

                if( resultPlayerHuman == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win player "+userName+"!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                } else if( resultPlayerComputer == numberOfRoundsWin ) {
                    currentResultsGame.setText("Game win Computer!\n" + userName + " -> " + resultPlayerHuman + "\t" + "Computer -> " + resultPlayerComputer);
                    resultTotalNumberOfRoundsHuman = 0;
                    resultTotalNumberOfRoundsComputer = 0;
                    btnPaper.setDisable(true);
                    btnRock.setDisable(true);
                    btnScissors.setDisable(true);
                }
            }
        };

        EventHandler<MouseEvent> eventHandlerPlayGameAgain = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnCloseWindowGame.setDisable(true);
                    btnPlayGameAgain.setDisable(true);
                    playGameAgain();
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };

        EventHandler<MouseEvent> eventHandlerCloseWindow = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnCloseWindowGame.setDisable(true);
                    btnPlayGameAgain.setDisable(true);
                    endGame();
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPaper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPaper);
        btnRock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRock);
        btnScissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerScissors);
        btnCloseWindowGame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCloseWindow);
        btnPlayGameAgain.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPlayGameAgain);

        HBox hboxButtons = new HBox(btnPaper, btnRock, btnScissors);//, btnCloseWindow, btnPlayGameAgain);
        hboxButtons.setSpacing(5);
        hboxButtons.setPadding(new Insets(550, 0, 0, 30));

        HBox hboxClosePlaybtns = new HBox(btnCloseWindowGame, btnPlayGameAgain);
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
        currentResultsGame.setText("Player " + userName + " ever execute \nfirst move!");
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

    Stage helpStageEndGame = new Stage();

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
        Image imageIconYes = new Image(getClass().getResourceAsStream("\\icons\\button-yes.png"));
        ImageView imageViewIconYes = new ImageView(imageIconYes);
        btnYes.setGraphic(imageViewIconYes);
        imageViewIconYes.setFitHeight(50);
        imageViewIconYes.setFitWidth(50);

        Button btnNo = new Button();
        Image imageIconNo = new Image(getClass().getResourceAsStream("\\icons\\button-no.png"));
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
                    helpStageEndGame.close();
                    primaryStage.close();
                    stage.close();
                } catch(NumberFormatException ex) {
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
                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);
                    helpStageEndGame.close();
                } catch(NumberFormatException ex) {
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

    Stage helpStageGameAgain = new Stage();

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
        Image imageIconYes = new Image(getClass().getResourceAsStream("\\icons\\button-yes.png"));
        ImageView imageViewIconYes = new ImageView(imageIconYes);
        btnYes.setGraphic(imageViewIconYes);
        imageViewIconYes.setFitHeight(50);
        imageViewIconYes.setFitWidth(50);

        Button btnNo = new Button();
        Image imageIconNo = new Image(getClass().getResourceAsStream("\\icons\\button-no.png"));
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
                    //userName.setText("");
                    //numberOfRounds.setNumber();
                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);
                    helpStageGameAgain.close();
                    stage.close();
                    primaryStage.close();
                    showLoginScreen();
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };
        btnYes.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerYes);

        EventHandler<MouseEvent> eventHandlerNo = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    btnCloseWindowGame.setDisable(false);
                    btnPlayGameAgain.setDisable(false);
                    helpStageGameAgain.close();
                } catch(NumberFormatException ex) {
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

    int totalNumberOfRoundsHuman = 0;
    int totalNumberOfRoundsComputer = 0;

    public void SaveResults(int numberOfRoundsHuman, int numberOfRoundsComputer) {
        totalNumberOfRoundsHuman += numberOfRoundsHuman;
        totalNumberOfRoundsComputer += numberOfRoundsComputer;
    }

    public int returnTotalNumberOfRoundsHuman() {
        return totalNumberOfRoundsHuman;
    }

    public int returnTotalNumberOfRoundsComputer() {
        return totalNumberOfRoundsComputer;
    }

    public static void main(String[] args) {
        launch(args);
    }



}
