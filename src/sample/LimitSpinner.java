
package sample;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * Implementation help class for TextFieldLimit!
 *
 **/

public class LimitSpinner extends HBox {

    private TextField limitField = new TextField();

    public LimitSpinner() {

        super();

        limitField.setText("");

        limitField.setPrefWidth(115);

        final int maxLength = 15;

        limitField.setOnKeyTyped(t -> {

            if (limitField.getText().length() > maxLength) {
                int pos = limitField.getCaretPosition();
                limitField.setText(limitField.getText(0, maxLength));
                limitField.positionCaret(pos);
            }

        });

        this.setAlignment(Pos.CENTER);

        this.getChildren().add(limitField);

    }

    public String getText() {
        return limitField.getText();
    }

    public void setText() {
        limitField.setText("");
    }

}