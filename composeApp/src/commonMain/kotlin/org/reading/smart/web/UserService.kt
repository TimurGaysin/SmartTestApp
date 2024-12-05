package org.reading.smart.web

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.reading.smart.model.PostSingle
import org.reading.smart.model.User

class UserService {

    private val client= HttpClient {
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys= true
                useAlternativeNames = false
            })
        }
    }

    suspend fun fetchUsers(): List<User> {
        return try {
            client.get("https://jsonplaceholder.typicode.com/users").body()
        } catch (e: Exception) {
            println("Error fetching users: ${e.message}")
            emptyList()
        }
    }

    suspend fun getCountOfPostsByUserId(idUser : Int): Int {
        return try {
            val response : List<PostSingle> = client.get("https://jsonplaceholder.typicode.com/users/$idUser/posts").body()
            response.size
        } catch (e: Exception) {
            println("Error fetching users: ${e.message}")
            return -1
        }
    }
}