package com.sudoku.sudokudesktop.buildlogic;

import com.sudoku.sudokudesktop.computationlogic.GameLogic;
import com.sudoku.sudokudesktop.persistence.LocalStorageImpl;
import com.sudoku.sudokudesktop.problemdomain.IStorage;
import com.sudoku.sudokudesktop.problemdomain.SudokuGame;
import com.sudoku.sudokudesktop.userinterface.IUserInterfaceContract;
import com.sudoku.sudokudesktop.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userinterface) throws IOException{
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try{
            initialState = storage.getGameData();
        }catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventLister uilogic = new ControlLogic(storage, userinterface);

        userinterface.setListener(uilogic);
        userinterface.updateBoard(initialState);
    }

}
