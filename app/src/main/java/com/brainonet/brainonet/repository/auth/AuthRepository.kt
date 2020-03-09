package com.brainonet.brainonet.repository.auth

import com.brainonet.brainonet.api.auth.ApiAuthService
import com.brainonet.brainonet.persistence.AuthTokenDao
import com.brainonet.brainonet.session.SessionManager

class AuthRepository
constructor(
    val authRepository: AuthRepository,
    authTokenDao: AuthTokenDao,
    apiAuthService: ApiAuthService,
    sessionManager: SessionManager
){

}