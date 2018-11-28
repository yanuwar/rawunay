package com.yanuwar.rawunay.presenter

import com.yanuwar.rawunay.model.Board
import com.yanuwar.rawunay.view.MainView

class MainPresenter {
    private lateinit var view: MainView
    private val board = Board()

    fun attachView(view: MainView){
        this.view = view
    }

    fun initGame() {
        board.startGame()
    }

    fun clickCell(tag: String) {
        val indexCell = tag.toInt()
        if (!board.isCellAlreadySet(indexCell)) {
            val player = board.getCurrentPlayer()
            board.setCell(indexCell)
            view.setBoard(tag, player)
            if (board.isCurrentPlayerWin(player)) {
                view.setWinPlayer(player)
            } else if (board.isDrawGame()) {
                view.setDrawGame()
            }
            board.changePlayer(player)
        } else {
            view.showWarning("Sudah di isi")
        }
    }

    fun restartGame() {
        board.restartGame()
    }
}