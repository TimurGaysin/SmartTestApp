package org.reading.smart.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

@Serializable
data class UserViewModel(
    val id: Int,
    val name: String,
    val email: String,
    var postCount: Int
)

@Serializable
data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
)

@Serializable
data class Geo(
    val lat: String,
    val lng: String

)

@Serializable
data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
)