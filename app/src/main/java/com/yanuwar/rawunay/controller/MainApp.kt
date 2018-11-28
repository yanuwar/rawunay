package com.yanuwar.rawunay.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.yanuwar.rawunay.R
import com.yanuwar.rawunay.model.Board
import com.yanuwar.rawunay.model.Player
import kotlinx.android.synthetic.main.activity_main_app.*

class MainApp : AppCompatActivity() {
    private val board = Board()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)

        initGame()

        tv_result.text = ""
        tv_winner.text = ""

        tv_reset.setOnClickListener {
            resetGame()
        }
    }

    fun onClickBtn(view: View) {
        clickCell(view.tag.toString())
    }

    fun initGame() {
        board.startGame()
    }

    fun clickCell(tag: String) {
        val indexCell = tag.toInt()
        if (!board.isCellAlreadySet(indexCell)) {
            val player = board.getCurrentPlayer()
            board.setCell(indexCell)
            setBoard(tag, player)
            if (board.isCurrentPlayerWin(player)) {
                setWinPlayer(player)
            } else if (board.isDrawGame()) {
                setDrawGame()
            }
            board.changePlayer(player)
        } else {
            showWarning("Sudah di isi")
        }
    }

    fun setBoard(tag: String, player: Player) {
        val cell = gl_board.findViewWithTag<Button>(tag)
        cell.text = player.identity
    }

    fun restartGame() {
        board.restartGame()
    }

    private fun resetGame() {
        restartGame()
        var i = 0
        while (i < gl_board.childCount) {
            val button: Button = gl_board.getChildAt(i) as Button
            button.text = ""
            i++
        }
        tv_result.text = ""
        tv_winner.text = ""
    }

    fun showWarning(text: String) {
        Toast.makeText(baseContext, text, Toast.LENGTH_SHORT).show()
    }

    fun setWinPlayer(player: Player) {
        tv_result.text = player.identity
        tv_winner.text = "Menang"
    }

    fun setDrawGame() {
        tv_winner.text = "Permainan Imbang"
    }
}
