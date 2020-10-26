
package sample;

import java.text.NumberFormat;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 *
 * Implementation help class for NumberTextField!
 *
 **/

public class NumberSpinner extends HBox {

    private NumberTextField numberField;

    public NumberSpinner() {
        this(0);
    }

    public NumberSpinner(Integer value) {
        this(value, NumberFormat.getInstance());
    }

    public NumberSpinner(Integer value, NumberFormat nf) {

        super();

        // TextField
        numberField = new NumberTextField(value, nf);
        numberField.setPrefWidth(40);

        final int maxLength = 2;            //      number digitals of integer number given in NumberTextField

        numberField.setOnKeyTyped(t -> {

            if (numberField.getText().length() > maxLength) {
                int pos = numberField.getCaretPosition();
                numberField.setText(numberField.getText(0, maxLength));
                numberField.positionCaret(pos);
            }

        });

        numberField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {

                keyEvent.getText().matches("[0-9]*");

            }

        });

        this.setAlignment(Pos.CENTER);

        this.getChildren().add(numberField);

    }

    public final void setNumber(Integer value) {
        numberField.setNumber(value);
    }

    public final Integer getNumber() {
        return numberField.getNumber();
    }

}