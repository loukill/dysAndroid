// ForumRepository.kt
package com.example.bottomnavbar.repository

import com.example.bottomnavbar.models.Forum
import com.example.bottomnavbar.network.RetrofitClient
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response


import java.util.List;

class ForumRepository {

    private val retrofitClient = RetrofitClient()
    suspend fun getAllForums(): List<Forum>? {
        // Logique pour récupérer la liste des forums depuis la source de données
        return null // Adapter en fonction de la logique réelle
    }

    suspend fun addForum(
        imageUri: MultipartBody.Part,
        title: RequestBody,
        description: RequestBody
    ): Response<String> {
        return retrofitClient.forumService.addForum(imageUri, title, description,)
    }

    suspend fun deleteForum(forumId: String): Unit? {
        return retrofitClient.forumService.deleteForum(forumId).body()
    }

    suspend fun updateForum(updatedForum: Forum) {
        // Logique pour mettre à jour les détails d'un forum dans la source de données
    }
}
