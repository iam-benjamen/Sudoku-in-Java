package com.sudoku.sudokudesktop;

import com.sudoku.sudokudesktop.userinterface.IUserInterfaceContract;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class SudokuApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        IUserInterfaceContract.View uiImpl = new UserInterfaceImpl(primaryStage);

        try{
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}