package madeexercises.MultiFormatCalculator.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import madeexercises.MultiFormatCalculator.ui.controller.BasesController;
import madeexercises.MultiFormatCalculator.ui.controller.FormatController;
import madeexercises.MultiFormatCalculator.ui.controller.TextInputController;
import madeexercises.MultiFormatCalculator.ui.model.CalculatorModel;

/**
 * Created by johankladder on 12-2-16.
 */
public class JavaFXGui extends Application {

    private Label baseLabel = new Label("Select your base");
    private Label formatLabel = new Label("Select your format");


    @Override
    public void start(Stage primaryStage) throws Exception {
        CalculatorModel calcModel = new CalculatorModel();

        BasesController baseController = new BasesController(calcModel);
        FormatController formatController = new FormatController(calcModel);
        TextInputController textInputController = new TextInputController(calcModel);

        StackPane root = new StackPane();
        GridPane pane = new GridPane();
        pane.setVgap(5);
        pane.add(baseLabel, 0, 0);
        pane.add(formatLabel, 0, 1);
        pane.add(baseController, 1, 0);
        pane.add(formatController, 1, 1);
        pane.add(textInputController, 2, 0,1,2);

        RowConstraints r1 = new RowConstraints();
        RowConstraints r2 = new RowConstraints();
        r1.setPercentHeight(50);
        r2.setPercentHeight(50);
        pane.getRowConstraints().addAll(r1,r2);

        ColumnConstraints c1 = new ColumnConstraints();
        ColumnConstraints c2 = new ColumnConstraints();
        ColumnConstraints c3 = new ColumnConstraints();
        c1.setPercentWidth(30);
        c2.setPercentWidth(20);
        c3.setPercentWidth(50);
        pane.getColumnConstraints().addAll(c1,c2,c3);



        root.getChildren().add(pane);
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(50);
        primaryStage.show();

    }


}
