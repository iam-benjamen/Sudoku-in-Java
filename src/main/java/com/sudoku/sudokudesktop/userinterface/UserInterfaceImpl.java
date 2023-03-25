package com.sudoku.sudokudesktop.userinterface;

import com.sudoku.sudokudesktop.problemDomain.Coordinates;
import com.sudoku.sudokudesktop.problemDomain.SudokuGame;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;

public class UserInterfaceImpl implements IUserInterfaceContract.View,
        EventHandler<KeyEvent> {

    private final Stage stage;
    private final Group root;

    private HashMap<Coordinates, SudokuTextField> textFieldCoordinates;
    private IUserInterfaceContract.EventLister listener;

    private static final double WINDOW_Y = 732;
    private static final double WINDOW_X = 668;
    private  static final double BOARD_PADDING = 50;
    private static final double BOARD_X_AND_Y = 576;

    private static final Color WINDOW_BACKGROUND_COLOR = Color.rgb(0,150,136);
    private static final Color BOARD_BACKGROUND_COLOR = Color.rgb(224,242,241);
    private static final String SUDOKU = "Sudoku";


    public UserInterfaceImpl(Stage stage){
        this.stage = stage;
        this.root = new Group();
        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    private void initializeUserInterface() {
        drawBackground(root);
        drawTitle(root);
        drawSudokuBoard(root);
        drawTextFields(root);
        drawGridLines(root);
        stage.show();
    }

    private void drawGridLines(Group root) {

    }

    private void drawSudokuBoard(Group root) {
    }

    private void drawTextFields(Group root) {

    }

    private void drawTitle(Group root) {
    }

    private void drawBackground(Group root) {

    }

    @Override
    public void setListener(IUserInterfaceContract.EventLister listener) {
        this.listener = listener;
    }

    @Override
    public void updateSquare(int x, int y, int input) {

    }

    @Override
    public void updateSquare(SudokuGame game) {

    }

    @Override
    public void showDialog(String Message) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void handle(KeyEvent keyEvent) {

    }
}
