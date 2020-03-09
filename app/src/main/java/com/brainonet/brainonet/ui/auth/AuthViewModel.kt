package com.brainonet.brainonet.ui.auth

import androidx.lifecycle.ViewModel
import com.brainonet.brainonet.repository.auth.AuthRepository

class AuthViewModel
constructor(
    val authRepository: AuthRepository
): ViewModel() {

}