package com.sudoku.sudokudesktop.userinterface.logic;

import com.sudoku.sudokudesktop.computationlogic.GameLogic;
import com.sudoku.sudokudesktop.constants.GameState;
import com.sudoku.sudokudesktop.constants.Messages;
import com.sudoku.sudokudesktop.problemdomain.IStorage;
import com.sudoku.sudokudesktop.problemdomain.SudokuGame;
import com.sudoku.sudokudesktop.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventLister {
    private IStorage storage;

    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input){
        try{
            SudokuGame gameData = storage.getGameData();
            int[][] newGridState = gameData.getCopyOfGridState();
            newGridState[x][y] = input;

            gameData = new SudokuGame(
                    GameLogic.checkForCompletion(newGridState),
                    newGridState
            );
            storage.updateGameData(gameData);

            view.updateSquare(x, y, input);

            if(gameData.getGameState() == GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        } catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }

    @Override
    public void onDialogClick(){
        try{
            storage.updateGameData(
                    GameLogic.getNewGame()
            );

            view.updateBoard(storage.getGameData());
        } catch (IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }
    }
}
