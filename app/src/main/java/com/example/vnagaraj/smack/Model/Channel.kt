package com.example.vnagaraj.smack.Model

/**
 * Created by vnagaraj on 09/10/2017.
 */
class Channel (val name: String , val description: String , val id: String){
    override fun toString(): String {
        return "#$name"
    }
}