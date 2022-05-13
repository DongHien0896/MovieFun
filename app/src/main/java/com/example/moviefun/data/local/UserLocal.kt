package com.example.moviefun.data.local

class UserLocal() : IUserLocal {

    companion object {
        private var INSTANCE: UserLocal? = null

        fun getInstance(): UserLocal {
            if (INSTANCE == null) {
                INSTANCE = UserLocal()
            }
            return INSTANCE as UserLocal
        }
    }
}
