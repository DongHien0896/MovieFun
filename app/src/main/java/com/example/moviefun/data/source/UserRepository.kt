package com.example.moviefun.data.source

import com.example.moviefun.data.local.IUserLocal
import com.example.moviefun.data.local.UserLocal
import com.example.moviefun.data.remote.IUserRemote
import com.example.moviefun.data.remote.UserRemote

class UserRepository(): IUserRemote, IUserLocal {
    companion object {
        private var INSTANCE: UserRepository? = null

        fun getInstance(): UserRepository {
            if (INSTANCE == null) {
                INSTANCE = UserRepository()
            }
            return INSTANCE as UserRepository
        }
    }

    private val userRemote = UserRemote.getInstance()
    private val userLocal = UserLocal.getInstance()
}
