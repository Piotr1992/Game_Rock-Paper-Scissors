
package sample;

import javafx.application.Application;
import javafx.stage.Stage;

//import javafx.stage.StageStyle;



public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

//            showLoginScreen();

            Login l = new Login();
            l.showLoginScreen();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }



}
