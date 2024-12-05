package org.reading.smart.model

import kotlinx.serialization.Serializable

@Serializable
data class PostSingle(val userId: Int, val id: Int, val title: String, val body: String
)