
package sample;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
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
import javafx.stage.StageStyle;

public class Game {
    private Stage primaryStage = new Stage();
    private HelpClass hc = new HelpClass();
    private int resultPlayerHuman = 0;
    private int resultPlayerComputer = 0;
    private int totalResultNumberOfRoundsHuman = 0;
    private int totalResultNumberOfRoundsComputer = 0;
    private int executedMoveComputer = 0;
    private PlayerComputer pC = new PlayerComputer();
    private Button btnPaper = new Button();
    private Button btnRock = new Button();
    private Button btnScissors = new Button();
    private Button btnCloseWindowGame = new Button();
    private Button btnPlayGameAgain = new Button();
    private Stage helpStageEndGame = new Stage();
    private Stage helpStageGameAgain = new Stage();
    private ImageView imageViewIconMovePlayer = hc.setImageView(  new Image( getClass().getResourceAsStream("") ), 300, 300   );
    private ImageView imageViewIconMoveComputer = hc.setImageView(  new Image( getClass().getResourceAsStream("") ), 300, 300   );
    private Image imageIconPaper = new Image(getClass().getResourceAsStream("icons/paper.png"));
    private ImageView imageViewIconPaper = hc.setImageView(  imageIconPaper, 100, 100   );
    private Image imageIconRock = new Image(getClass().getResourceAsStream("icons/rock.png"));
    private ImageView imageViewIconRock = hc.setImageView(  imageIconRock, 100, 100   );
    private Image imageIconScissors = new Image(getClass().getResourceAsStream("icons/scissors.jpg"));
    private ImageView imageViewIconScissors = hc.setImageView(  imageIconScissors, 100, 100   );
    private Image imageIconCloseWindow = new Image(getClass().getResourceAsStream("icons/button-close.png"));
    private ImageView imageViewIconCloseWindow = hc.setImageView(  imageIconCloseWindow, 50, 50   );
    private Image imageIconPlayGame = new Image(getClass().getResourceAsStream("icons/play-again-button.png"));
    private ImageView imageViewIconPlayGame = hc.setImageView(  imageIconPlayGame, 50, 150   );
    private Label currentResultsGame = new Label();
    private int executedMovePlayer = 0;
    private String winnerRound = "";
    private HBox hboxRect = hc.setHBox( new HBox(imageViewIconMovePlayer, imageViewIconMoveComputer), 50, 175, 0, 0, 150 );
    private HBox hboxPlayerComputer = new HBox();
    HBox hboxPlayerPerson = new HBox();
    HBox hboxInfoMovesUser = new HBox();
    HBox hboxlabelUserName = new HBox();
    HBox hboxlabelComputer = new HBox();
    Font font30ArialBlack = Font.font("Arial Black", FontWeight.BOLD, FontPosture.ITALIC, 30);
    Font font18Calibri = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18);

    public void playGame(String user, int wonRounds) throws Exception{
        helpStageEndGame.initStyle(StageStyle.UNDECORATED);
        helpStageGameAgain.initStyle(StageStyle.UNDECORATED);
        if( user.length() <= 8 ) {
            currentResultsGame = hc.setLabel("Limit won rounds: " + wonRounds + "\nPlayer \"" + user + "\" ever execute \nfirst move!", font30ArialBlack);
        } else {
            currentResultsGame = hc.setLabel("Limit won rounds: " + wonRounds + "\nPlayer \"" + user + "\" ever \nexecute first move!", font30ArialBlack);
        }
        ImageView imageViewIconPlayerComputer = hc.setImageViewPlayer(  new Image(getClass().getResourceAsStream("icons/computer.png")),
                                                                        150, 150, 200, 50   );
        ImageView imageViewIconPlayerPerson = hc.setImageViewPlayer(  new Image(getClass().getResourceAsStream("icons/person.png")),
                                                                    150, 100, 200, 50   );
        Label labelUserName = hc.setLabel(user, font18Calibri);
        Label labelComputer = hc.setLabel("Computer", font18Calibri);
        Label infoMovesUser = hc.setLabel("Below are three moves. Click one from them!", font18Calibri);
        btnPaper.setGraphic(imageViewIconPaper);
        btnRock.setGraphic(imageViewIconRock);
        btnScissors.setGraphic(imageViewIconScissors);
        btnCloseWindowGame.setGraphic(imageViewIconCloseWindow);
        btnPlayGameAgain.setGraphic(imageViewIconPlayGame);
        btnPaper.setDisable(false);
        btnRock.setDisable(false);
        btnScissors.setDisable(false);
        hboxPlayerComputer = hc.setHBox( new HBox(imageViewIconPlayerComputer), 0, 15, 0, 0, 830 );
        hboxPlayerPerson = hc.setHBox( new HBox(imageViewIconPlayerPerson), 0, 15, 0, 0, 20 );
        hboxInfoMovesUser = hc.setHBox( new HBox(infoMovesUser), 0, 520, 0, 0, 40 );
        hboxlabelUserName = hc.setHBox( new HBox(labelUserName), 0, 180, 0, 0, 15 );
        hboxlabelComputer = new HBox( hc.setHBox( new HBox(labelComputer), 0, 180, 0, 0, 870 ) );

        EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                executedMoveComputer = pC.executeMove();
                try {
                    imageViewIconMovePlayer.setImage(imageIconPaper);
                    executedMovePlayer = 2;
                    if ( executedMoveComputer == 1 ) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerHuman = 1;
                        resultPlayerComputer = 0;
                        winnerRound = user;
                    } else if ( executedMoveComputer == 2 ) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 0;
                        winnerRound = "";
                    } else if ( executedMoveComputer == 3 ) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 1;
                        winnerRound = "Computer";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                displayResults(user, wonRounds, resultPlayerHuman, resultPlayerComputer);
            }
        };

        EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                executedMoveComputer = pC.executeMove();
                try {
                    imageViewIconMovePlayer.setImage(imageIconRock);
                    executedMovePlayer = 1;
                    if (executedMoveComputer == 1) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 0;
                        winnerRound = "";
                    } else if (executedMoveComputer == 2) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 1;
                        winnerRound = "Computer";
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerHuman = 1;
                        resultPlayerComputer = 0;
                        winnerRound = user;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                displayResults(user, wonRounds, resultPlayerHuman, resultPlayerComputer);
            }
        };

        EventHandler<MouseEvent> eventHandlerScissors = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                executedMoveComputer = pC.executeMove();
                try {
                    imageViewIconMovePlayer.setImage(imageIconScissors);
                    executedMovePlayer = 3;
                    if (executedMoveComputer == 1) {
                        imageViewIconMoveComputer.setImage(imageIconRock);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 1;
                        winnerRound = "Computer";
                    } else if (executedMoveComputer == 2) {
                        imageViewIconMoveComputer.setImage(imageIconPaper);
                        resultPlayerHuman = 1;
                        resultPlayerComputer = 0;
                        winnerRound = user;
                    } else if (executedMoveComputer == 3) {
                        imageViewIconMoveComputer.setImage(imageIconScissors);
                        resultPlayerHuman = 0;
                        resultPlayerComputer = 0;
                        winnerRound = "";
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                displayResults(user, wonRounds, resultPlayerHuman, resultPlayerComputer);
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
                    hc.showMessage( primaryStage, helpStageGameAgain, null, null,
                                    btnPaper, btnRock, btnScissors, btnCloseWindowGame, btnPlayGameAgain,
                                    wonRounds,"Are you sure you want to end the current game?", 3,
                                    totalResultNumberOfRoundsHuman,  totalResultNumberOfRoundsComputer );
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
                    hc.showMessage( primaryStage, helpStageEndGame, null, null,
                            btnPaper, btnRock, btnScissors, btnCloseWindowGame, btnPlayGameAgain,
                            wonRounds,"Are you sure you want to end the game?", 2,
                            totalResultNumberOfRoundsHuman,  totalResultNumberOfRoundsComputer );
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
        HBox hboxButtons = hc.setHBox(new HBox(btnPaper, btnRock, btnScissors), 5, 550, 0, 0, 30);
        HBox hboxClosePlaybtns = hc.setHBox(new HBox(btnCloseWindowGame, btnPlayGameAgain), 50, 10, 0, 0, 350);
        Group firstGroup = new Group();
        firstGroup = hc.setGroup(firstGroup, hboxButtons, -310, -10);
        Group secondGroup = new Group();
        secondGroup = hc.setGroup(secondGroup, hboxClosePlaybtns, -200, -300);
        HBox hboxCurrentResultsGame = hc.setHBox( new HBox(currentResultsGame), 0, 550, 5, 0, 405 );
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
        root.getChildren().add(secondGroup);
        root.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));
        Scene scene = new Scene(root,1000,700);
        primaryStage = hc.setStage(scene, primaryStage);
    }

    public void displayResults(String user, int wonRounds, int resultPlayerHuman, int resultPlayerComputer) {
        if( resultPlayerHuman==1 ) {
            totalResultNumberOfRoundsHuman += 1;
        } else if( resultPlayerComputer==1 ) {
            totalResultNumberOfRoundsComputer += 1;
        }
        if( totalResultNumberOfRoundsHuman == wonRounds ) {
            currentResultsGame.setText("Limit won rounds: " + wonRounds +
                                        "\nGame won \""+user+"\"!\n\"" + user + "\"->" + totalResultNumberOfRoundsHuman +
                                                        " " + "Computer->" + totalResultNumberOfRoundsComputer);
            btnPaper.setDisable(true);
            btnRock.setDisable(true);
            btnScissors.setDisable(true);
        } else if( totalResultNumberOfRoundsComputer == wonRounds ) {
            currentResultsGame.setText("Limit won rounds: " + wonRounds +
                                        "\nGame won Computer!\n\"" + user + "\"->" + totalResultNumberOfRoundsHuman +
                                                        " " + "Computer->" + totalResultNumberOfRoundsComputer);
            btnPaper.setDisable(true);
            btnRock.setDisable(true);
            btnScissors.setDisable(true);
        } else {
            currentResultsGame.setText("Limit won rounds: " + wonRounds +
                                        "\nCurrent result game:\n\"" + user + "\"->" + totalResultNumberOfRoundsHuman +
                                                            " " + "Computer->" + totalResultNumberOfRoundsComputer);
        }
    }
}
