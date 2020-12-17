package com.saifi369.conditionalnavigation

class UserLoginInfo {
    companion object{
        var user:User? = null
    }
}

data class User(val username:String)