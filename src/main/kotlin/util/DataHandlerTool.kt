package net.moxi.exploration.atri.util

import net.moxi.exploration.atri.Plugin

fun List<String>.randomTakeItem():String{
    val taken = this.shuffled().take(1)[0]
    if(taken == "" || taken.isEmpty()){
        return this.shuffled().take(1)[0]
    }
    return taken
}

fun probabilityBool(probability:Double):Boolean{
    return (1..100).random() <= probability*100
}

