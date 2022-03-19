package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Window extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    Button button;
    Stage window;
    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label label1 = new Label("cena 1 ");//

        Button button = new Button("migrar para proxima cena");
        button.setOnAction(e -> window.setScene(scene2));

        // criando uma box vertical
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button);
        scene1 = new Scene(layout1, 600, 900);

        Button button2 = new Button("retroceder para cena anterior");
        button2.setOnAction(e -> window.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 300);

        window.setScene(scene2);
        window.setTitle("testando cenas");
        window.show();

    }

}
