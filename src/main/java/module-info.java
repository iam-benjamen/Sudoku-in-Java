module com.sudoku.sudokudesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sudoku.sudokudesktop to javafx.fxml;
    exports com.sudoku.sudokudesktop;
}