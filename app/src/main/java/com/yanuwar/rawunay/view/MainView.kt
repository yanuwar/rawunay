package com.yanuwar.rawunay.view

import com.yanuwar.rawunay.model.Player

interface MainView {
    fun setBoard (tag: String, player: Player)
    fun setWinPlayer(player: Player)
    fun setDrawGame()
    fun showWarning(text: String)
}