package com.yanuwar.rawunay.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.yanuwar.rawunay.R
import com.yanuwar.rawunay.model.Player
import com.yanuwar.rawunay.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main_app.*

class MainApp : AppCompatActivity(), MainView {
    override fun setDrawGame() {
        tv_winner.text = "Permainan Imbang"
    }

    override fun setWinPlayer(player: Player) {
        tv_result.text = player.identity
        tv_winner.text = "Menang"
    }

    override fun showWarning(text: String) {
        Toast.makeText(baseContext, text, Toast.LENGTH_SHORT).show()
    }

    override fun setBoard(tag: String, player: Player) {
        val cell = gl_board.findViewWithTag<Button>(tag)
        cell.text = player.identity
    }

    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)
        mainPresenter = MainPresenter()
        mainPresenter.attachView(this)
        mainPresenter.initGame()

        tv_result.text = ""
        tv_winner.text = ""

        tv_reset.setOnClickListener {
            resetGame()
        }
    }

    fun onClickBtn(view: View) {
        mainPresenter.clickCell(view.tag.toString())
    }

    private fun resetGame() {
        mainPresenter.restartGame()
        var i = 0
        while (i < gl_board.childCount) {
            val button: Button = gl_board.getChildAt(i) as Button
            button.text = ""
            i++
        }
        tv_result.text = ""
        tv_winner.text = ""
    }
}
