// ForumService.kt
package com.example.bottomnavbar.network

import com.example.bottomnavbar.models.Forum
import retrofit2.Response
import retrofit2.http.*

interface ForumService {
    @GET("/forums")
    suspend fun getAllForums(): Response<List<Forum>>

    @POST("/forums")
    suspend fun addForum(@Body newForum: Forum): Response<String>

    @DELETE("/forums/{forumId}")
    suspend fun deleteForum(@Path("forumId") forumId: String): Response<String>

    @PUT("/forums/{forumId}")
    suspend fun updateForum(@Path("forumId") forumId: String, @Body updatedForum: Forum): Response<String>
}
