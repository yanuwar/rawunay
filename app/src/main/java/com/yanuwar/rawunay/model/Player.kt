package com.yanuwar.rawunay.model

class Player(
        val identity: String
) {
    fun equal(player: Player): Boolean {
        return player.identity == identity
    }
}