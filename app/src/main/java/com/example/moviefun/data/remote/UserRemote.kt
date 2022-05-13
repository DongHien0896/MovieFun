package com.example.moviefun.data.remote


class UserRemote(): IUserRemote {

    companion object {
        private var INSTANCE: UserRemote? = null

        fun getInstance(): UserRemote {
            if (INSTANCE == null) {
                INSTANCE = UserRemote()
            }
            return INSTANCE as UserRemote
        }
    }
}
