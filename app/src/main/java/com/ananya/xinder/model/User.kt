package com.ananya.xinder.model

import com.stfalcon.chatkit.commons.models.IUser

/*
 * Created by troy379 on 04.04.17.
 */
data class User(private val id: String, private val name: String, private val avatar: String, val isOnline: Boolean) : IUser {
    override fun getId(): String {
        return id
    }

    override fun getName(): String {
        return name
    }

    override fun getAvatar(): String {
        return avatar
    }

}