package com.yanuwar.rawunay.model

class Board {
    private val cells = arrayListOf<Cell>()
    private var currentPlayer: Int = 0
    private val players = arrayOf(Player("X"), Player("O"))
    var isGameOver = false

    fun startGame() {
        restartGame()
    }

    fun restartGame() {
        cells.clear()
        currentPlayer = 0
        initBoard()
    }

    fun initBoard() {
        var i = 1
        while (i <= 9) {
            cells.add(Cell(i, null))
            i++
        }
    }

    fun setCell(tag: Int) {
        cells.forEachIndexed { index, cell ->
            if (cell.tag == tag) {
                cell.player = players[currentPlayer]
                cells[index] = cell
            }
        }
    }

    fun changePlayer(player: Player) {
        if (players[0].equal(player)) {
            currentPlayer = 1
        } else {
            currentPlayer = 0
        }
    }

    fun isCellAlreadySet(tag: Int): Boolean {
        return (cells.find { it.tag == tag }?.player != null)
    }

    fun getCurrentPlayer(): Player {
        return players[currentPlayer]
    }

    fun isCurrentPlayerWin(player: Player): Boolean {
        return ((cells[0].player?.identity == player.identity &&
                cells[1].player?.identity == player.identity &&
                cells[2].player?.identity == player.identity)
                || (cells[3].player?.identity == player.identity &&
                cells[4].player?.identity == player.identity &&
                cells[5].player?.identity == player.identity)
                || (cells[6].player?.identity == player.identity &&
                cells[7].player?.identity == player.identity &&
                cells[8].player?.identity == player.identity)
                || (cells[0].player?.identity == player.identity &&
                cells[4].player?.identity == player.identity &&
                cells[8].player?.identity == player.identity)
                || (cells[2].player?.identity == player.identity &&
                cells[4].player?.identity == player.identity &&
                cells[6].player?.identity == player.identity)
                || (cells[1].player?.identity == player.identity &&
                cells[4].player?.identity == player.identity &&
                cells[7].player?.identity == player.identity))
    }

    fun isDrawGame(): Boolean {
        var isDraw = true
        cells.forEach {
            if (it.player == null) {
                isDraw = false
            }
        }
        return isDraw
    }
}