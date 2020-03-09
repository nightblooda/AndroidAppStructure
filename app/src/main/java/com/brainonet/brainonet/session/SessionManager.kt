package com.brainonet.brainonet.session

import android.app.Application
import com.brainonet.brainonet.persistence.AuthTokenDao

class SessionManager
constructor(
    val authTokenDao: AuthTokenDao,
    val application: Application
){

}