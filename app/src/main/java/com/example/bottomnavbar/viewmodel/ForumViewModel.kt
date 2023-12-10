// ForumViewModel.kt
package com.example.bottomnavbar.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.bottomnavbar.models.Forum
import com.example.bottomnavbar.repository.ForumRepository

class ForumViewModel : ViewModel() {

    //-----get All events
    private val repository = ForumRepository()

    val forums = liveData {
        val eventData = repository.getAllForums()
        emit(eventData ?: emptyList())
    }


    // LiveData pour stocker la liste des forums
    private val _forumList = MutableLiveData<List<Forum>>()
    val forumList: LiveData<List<Forum>> get() = _forumList

    // Fonction pour mettre à jour la liste des forums
    fun updateForumList(newForumList: List<Forum>) {
        _forumList.value = newForumList
    }

    // Vous pouvez ajouter d'autres fonctions ou propriétés selon vos besoins
}
