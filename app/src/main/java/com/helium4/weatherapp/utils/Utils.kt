package com.helium4.weatherapp.utils

val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";

fun isEmailValid(email: String): Boolean {
    return EMAIL_REGEX.toRegex().matches(email);
}