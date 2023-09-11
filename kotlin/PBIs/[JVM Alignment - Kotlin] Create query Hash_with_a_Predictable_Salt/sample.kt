package com.example.sampleautomation2

import java.security.MessageDigest

fun hashWithPredictableSalt(password: String, salt: String): String {
    val saltedPassword = salt + password
    val md5 = MessageDigest.getInstance("MD5")
    md5.update(salt) //usage of hardcoded salt
    val hashBytes = md5.digest(saltedPassword.toByteArray())
    return hashBytes.joinToString("") { "%02x".format(it) }
}

fun main() {
    val password = "password123"
    val salt = "mysalt"
    val hashedPassword = hashWithPredictableSalt(password, salt)
    println("Hashed password: $hashedPassword")
}
