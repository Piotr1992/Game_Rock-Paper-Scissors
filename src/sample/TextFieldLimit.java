
package sample;

import javafx.scene.control.TextField;
/**
 *
 * Implementation Textfield for limit number chars!
 *
 **/
public class TextFieldLimit extends TextField {

    private static final int LIMIT = 5;

    public TextFieldLimit() {

        final TextField textField = new TextField();

        final int maxLength = 2;

        textField.setOnKeyTyped(t -> {

            if (textField.getText().length() > maxLength) {
                int pos = textField.getCaretPosition();
                textField.setText(textField.getText(0, maxLength));
                textField.positionCaret(pos);
            }

        });

        this.getChildren().add(textField);

    }
}