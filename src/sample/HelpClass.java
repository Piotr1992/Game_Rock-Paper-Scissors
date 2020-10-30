
package sample;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

class HelpClass {

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

}
