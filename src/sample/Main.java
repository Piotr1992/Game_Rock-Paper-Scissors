
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

//            do {

            playGame("Adam", 2);

//            } while( !end );
            //showLoginScreen();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void showLoginScreen() {

        Stage stage = new Stage();

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        stage.setResizable(false);

        Label label = new Label("Input below data!");
        Font font = Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15);
        label.setFont(font);
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

        TextField userName = new TextField();
        userName.setPromptText("Input your name: ");
        //TextField numberOfRounds = new TextField();

//        NumberTextField numberOfRounds = new NumberTextField();

        NumberSpinner numberOfRounds = new NumberSpinner();

//        numberOfRounds.setPromptText("Input number of rounds: ");

        Button btnPlayGame = new Button();
        //btnPlayGame.setText("Play");
        Image imageIconPlayGame = new Image( getClass().getResourceAsStream("\\icons\\button-play.png") );
        ImageView imageViewIconPlayGame = new ImageView(imageIconPlayGame);
        imageViewIconPlayGame.setFitHeight(25);
        imageViewIconPlayGame.setFitWidth(50);
        btnPlayGame.setGraphic(imageViewIconPlayGame);

        EventHandler<MouseEvent> eventHandlerPlayGame = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                try {
                    if( !userName.getText().equals("") && numberOfRounds.getNumber().intValue() > 0 ) {
                        stage.close();
                        playGame(userName.getText(), numberOfRounds.getNumber().intValue());
                    } else {
                        System.out.println("fdsghs");
                    }
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        };

        btnPlayGame.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPlayGame);

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

    int executedMovePlayer = 0;
    int numberOfRoundsHuman = 0;
    int numberOfRoundsComputer = 0;
    int executedMoveComputer = 0;

    public void playGame(String userName, int numberOfRoundsWin) {

        Stage primaryStage = new Stage();

        primaryStage.setResizable(false);

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

        StackPane root = new StackPane();

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



        PlayerComputer pC = new PlayerComputer();
        boolean end = false;
        String winnerGame = "";

        int resultGlobalExecutedMovePlayer = 0;
        int resultTotalNumberOfRoundsHuman = 0;
        int resultTotalNumberOfRoundsComputer = 0;



            EventHandler<MouseEvent> eventHandlerPaper = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
/*                    int executedMovePlayer = 0;
                    int numberOfRoundsHuman = 0;
                    int numberOfRoundsComputer = 0;             */

                    executedMoveComputer = pC.executeMove();

                    try {
                        imageViewIconMovePlayer.setImage(imageIconPaper);
                        executedMovePlayer = 2;
                        if (executedMoveComputer == 1) {
                            imageViewIconMoveComputer.setImage(imageIconRock);
                            numberOfRoundsHuman++;
                        } else if (executedMoveComputer == 2) {
                            imageViewIconMoveComputer.setImage(imageIconPaper);
                        } else if (executedMoveComputer == 3) {
                            imageViewIconMoveComputer.setImage(imageIconScissors);
                            numberOfRoundsComputer++;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    SaveResults(executedMovePlayer, numberOfRoundsHuman, numberOfRoundsComputer);
                }
            };

            EventHandler<MouseEvent> eventHandlerRock = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
/*                    int executedMovePlayer = 0;
                    int numberOfRoundsHuman = 0;
                    int numberOfRoundsComputer = 0;                     */

                    executedMoveComputer = pC.executeMove();

                    try {
                        imageViewIconMovePlayer.setImage(imageIconRock);
                        executedMovePlayer = 1;
                        if (executedMoveComputer == 1) {
                            imageViewIconMoveComputer.setImage(imageIconRock);
                        } else if (executedMoveComputer == 2) {
                            imageViewIconMoveComputer.setImage(imageIconPaper);
                            numberOfRoundsComputer++;
                        } else if (executedMoveComputer == 3) {
                            imageViewIconMoveComputer.setImage(imageIconScissors);
                            numberOfRoundsHuman++;
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    SaveResults(executedMovePlayer, numberOfRoundsHuman, numberOfRoundsComputer);
                }
            };

            EventHandler<MouseEvent> eventHandlerScissors = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
/*                    int executedMovePlayer = 0;
                    int numberOfRoundsHuman = 0;
                    int numberOfRoundsComputer = 0;                 */

                    executedMoveComputer = pC.executeMove();

                    try {
                        imageViewIconMovePlayer.setImage(imageIconScissors);
                        executedMovePlayer = 3;
                        if (executedMoveComputer == 1) {
                            imageViewIconMoveComputer.setImage(imageIconRock);
                            numberOfRoundsComputer++;
                        } else if (executedMoveComputer == 2) {
                            imageViewIconMoveComputer.setImage(imageIconPaper);
                            numberOfRoundsHuman++;
                        } else if (executedMoveComputer == 3) {
                            imageViewIconMoveComputer.setImage(imageIconScissors);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    SaveResults(executedMovePlayer, numberOfRoundsHuman, numberOfRoundsComputer);
                }
            };


            btnPaper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerPaper);
            btnRock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerRock);
            btnScissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerScissors);


//        while( !end ) {

            resultGlobalExecutedMovePlayer = returnGlobalExecutedMovePlayer();
            resultTotalNumberOfRoundsHuman = returnTotalNumberOfRoundsHuman();
            resultTotalNumberOfRoundsComputer = returnTotalNumberOfRoundsComputer();

            if (resultTotalNumberOfRoundsHuman == numberOfRoundsWin) {
                end = true;
                winnerGame = userName;
            } else if (resultTotalNumberOfRoundsComputer == numberOfRoundsWin) {
                end = true;
                winnerGame = "Computer";
            }
            //displayResults(winnerGame, resultTotalNumberOfRoundsHuman, resultTotalNumberOfRoundsComputer, resultGlobalExecutedMovePlayer, executedMoveComputer, userName);

//        }


        HBox hboxbuttons = new HBox(btnPaper, btnRock, btnScissors);
        hboxbuttons.setSpacing(5);
        hboxbuttons.setPadding(new Insets(550, 0, 0, 30));

        HBox hboxRect = new HBox(imageViewIconMovePlayer, imageViewIconMoveComputer);
        hboxRect.setPadding(new Insets(175, 0, 0, 150));
        hboxRect.setSpacing(50);


        Label currentResultsGame = new Label();
        currentResultsGame.setText("Currently results game:");
        currentResultsGame.setFont(font);
        currentResultsGame.setTextFill(Color.RED);
        currentResultsGame.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox hboxCurrentResultsGame = new HBox(currentResultsGame);
        hboxCurrentResultsGame.setPadding(new Insets(520, 0, 0, 500));


        root.getChildren().add(hboxRect);
        root.getChildren().add(hboxPlayerComputer);
        root.getChildren().add(hboxPlayerPerson);
        root.getChildren().add(hboxInfoMovesUser);
        root.getChildren().add(hboxlabelUserName);
        root.getChildren().add(hboxlabelComputer);
        root.getChildren().add(hboxbuttons);

        root.setBackground(new Background(new BackgroundFill(Color.GREEN, new CornerRadii(25), Insets.EMPTY)));

        Scene scene = new Scene(root,1000,700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public String rulesGame(int movePlayerHuman, int movePlayerComputer) {
        String resultOfRound = "";

        if( movePlayerHuman == 1 && movePlayerComputer == 2 ) {
            resultOfRound = "Computer";
        } else if( movePlayerHuman == 2 && movePlayerComputer == 1 ) {
            resultOfRound = "Human";
        } else if( movePlayerHuman == 1 && movePlayerComputer == 3 ) {
            resultOfRound = "Human";
        } else if( movePlayerHuman == 3 && movePlayerComputer == 1 ) {
            resultOfRound = "Computer";
        } else if( movePlayerHuman == 2 && movePlayerComputer == 3 ) {
            resultOfRound = "Computer";
        } else if( movePlayerHuman == 3 && movePlayerComputer == 2 ) {
            resultOfRound = "Human";
        } else {
            resultOfRound = "";
        }
        return resultOfRound;
    }

    public void displayResults(String winner, int resultPlayerHuman, int resultPlayerComputer, int movePlayerHuman, int movePlayerComputer, String UserName) {
        System.out.println("\n\n\nExecute moves players:");
        System.out.println("Executed move " + UserName + " -> " + movePlayerHuman);
        System.out.println("Execute move Computer -> " + movePlayerComputer);

        if( resultPlayerHuman != resultPlayerComputer ) {
            System.out.println("This round win -> " + winner);
        } else {
            System.out.println("There was a draw this round!");
        }
        System.out.println("Currently result game : \nPlayer-" + UserName + " -> " + resultPlayerHuman + "\tPlayer-Computer -> " + resultPlayerComputer + "\n\n\n");
    }

    int globalExecutedMovePlayer = 0;
    int totalNumberOfRoundsHuman = 0;
    int totalNumberOfRoundsComputer = 0;

    public void SaveResults(int executedMovePlayer, int numberOfRoundsHuman, int numberOfRoundsComputer) {
        globalExecutedMovePlayer = executedMovePlayer;
        totalNumberOfRoundsHuman += numberOfRoundsHuman;
        totalNumberOfRoundsComputer += numberOfRoundsComputer;
    }

    public int returnGlobalExecutedMovePlayer() {
        return globalExecutedMovePlayer;
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
