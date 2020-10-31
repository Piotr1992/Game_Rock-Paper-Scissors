
package sample;

import javafx.application.Platform;
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

class HelpClass {

    public void showMessage(    Stage stage, Stage helpStage, Button btnPlayGame, Button btnCloseWindowForm, Button btnPaper,
                                Button btnRock, Button btnScissors, Button btnCloseWindowGame, Button btnPlayGameAgain,
                                int wonRounds, String textOfMessage, int idMessage,
                                int totalResultNumberOfRoundsHuman, int totalResultNumberOfRoundsComputer   ) {

        StackPane root = new StackPane();
        Scene scene = new Scene(root,400,150);
        root = showWindowBtnYesNo(root);
        Label labelAsk = setLabel(  textOfMessage,  Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 18)    );
        Button btnYes = new Button();
        btnYes = setButton(btnYes, setImageView(   new Image(getClass().getResourceAsStream("icons/button-yes.png")), 50, 50    ));
        Button btnNo = new Button();
        btnNo = setButton(btnNo, setImageView(   new Image(getClass().getResourceAsStream("icons/button-no.png")), 50, 50    ));

        if( idMessage == 1 ) {
            EventHandler<MouseEvent> eventHandlerYes = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        stage.close();
                        helpStage.close();
                    } catch (Exception ex) {
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
                        helpStage.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            btnNo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNo);
        } else if( idMessage == 2 ) {
            EventHandler<MouseEvent> eventHandlerYes = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        helpStage.close();
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
                        if( ( totalResultNumberOfRoundsHuman != wonRounds ) && ( totalResultNumberOfRoundsComputer != wonRounds ) ) {
                            btnPaper.setDisable(false);
                            btnRock.setDisable(false);
                            btnScissors.setDisable(false);
                        }
                        btnCloseWindowGame.setDisable(false);
                        btnPlayGameAgain.setDisable(false);
                        helpStage.close();
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            btnNo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNo);
        } else if( idMessage == 3 ) {
            EventHandler<MouseEvent> eventHandlerYes = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    try {
                        btnCloseWindowGame.setDisable(false);
                        btnPlayGameAgain.setDisable(false);
                        helpStage.close();
                        stage.close();
                        Main m = new Main();
                        m.start(new Stage());
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
                        if( ( totalResultNumberOfRoundsHuman != wonRounds ) && ( totalResultNumberOfRoundsComputer != wonRounds ) ) {
                            btnPaper.setDisable(false);
                            btnRock.setDisable(false);
                            btnScissors.setDisable(false);
                        }
                        btnCloseWindowGame.setDisable(false);
                        btnPlayGameAgain.setDisable(false);
                        helpStage.close();
                    } catch(Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };
            btnNo.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerNo);
        }
        root.getChildren().add(setHBox(new HBox(labelAsk), 0, 25, 0, 0, 30));
        root.getChildren().add(setHBox(new HBox(btnYes, btnNo), 50, 75, 0, 0, 100));
        setHelpStage(scene, helpStage);
    }

    public Label setLabel(String txt, Font font) {
        Label label = new Label(txt);
        label.setFont(font);
        label.setTextFill(Color.RED);
        label.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        return label;
    }

    public ImageView setImageView(Image image, int height, int width) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        return imageView;
    }

    public ImageView setImageViewPlayer(Image image, int height, int width, int x, int y) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
    }

    public HBox setHBox(HBox gHBox, int spacing, int top, int right, int bottom, int left) {
        gHBox.setSpacing(spacing);
        gHBox.setPadding(new Insets(top, right, bottom, left));
        return gHBox;
    }

    public Stage setStage(Scene scene, Stage stage) {
        stage.setOnCloseRequest(e -> Platform.exit());
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
        return stage;
    }

    public Stage setHelpStage(Scene scene, Stage stage) {
        stage.setOnCloseRequest(e -> Platform.exit());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        return stage;
    }

    public Button setButton(Button btn, ImageView imgV) {
        btn.setGraphic(imgV);
        return btn;
    }

    public StackPane showWindowBtnYesNo(StackPane root) {
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, new CornerRadii(25), Insets.EMPTY)));
        return root;
    }

    public Group setGroup(Group firstGroup, HBox hboxButtons, int x, int y) {
        firstGroup.getChildren().add(hboxButtons);
        firstGroup.setTranslateX(x);
        firstGroup.setTranslateY(y);
        return firstGroup;
    }
}
