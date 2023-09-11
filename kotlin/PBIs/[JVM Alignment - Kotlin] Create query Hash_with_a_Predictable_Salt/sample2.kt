package com.example.sampleautomation1

import java.security.MessageDigest

fun hashWithPredictableSalt(password: String, salt: String): String {
    val saltedPassword = salt + password
    val sha256 = MessageDigest.getInstance("SHA-256")
    sha256.update(salt) //usage of hardcoded salt
    val hashBytes = sha256.digest(saltedPassword.toByteArray())
    return hashBytes.joinToString("") { "%02x".format(it) }
}

fun main() {
    val password = "password123"
    val salt = "mysalt"
    val hashedPassword = hashWithPredictableSalt(password, salt)
    println("Hashed password: $hashedPassword")
}
