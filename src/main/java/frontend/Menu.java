package frontend;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application implements EventHandler<ActionEvent> {
    public static void main(String args[]) {
        launch(args);
    }

    Button button;
    Stage window;
    Scene scene;
    StackPane layout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Banco (nome do banco)");

        button = new Button(); // criando um botao
        button.setText("Click me"); // definindo o botao
        button.setOnAction(this); // quando clicar no bottão ele ira chmar o metodo handle dessa classe

        layout = new StackPane(); // criando um layout simple
        layout.getChildren().add(button); // colocando o button no layout

        scene = new Scene(layout, 300, 250); // scene é basicamente a janela toda
        primaryStage.setScene(scene); // a primeira janela
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) { // vai verificar qual botão foi apertado;
            TesteFx teste = new TesteFx();
            teste.teste();
            Text scenetitle = new Text("você apertou o botão");
            layout.getChildren().add(scenetitle);

        }
    }
}
