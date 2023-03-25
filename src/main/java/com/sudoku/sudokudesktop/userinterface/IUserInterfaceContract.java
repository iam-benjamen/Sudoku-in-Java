package com.sudoku.sudokudesktop.userinterface;

import com.sudoku.sudokudesktop.problemDomain.SudokuGame;

public interface IUserInterfaceContract {
    interface EventLister{
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }

    interface View{
        void setListener(IUserInterfaceContract.EventLister listener);
        void updateSquare(int x, int y, int input);
        void updateSquare(SudokuGame game);
        void showDialog(String Message);
        void showError(String message);
    }
}
