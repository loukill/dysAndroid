// ForumViewHolder.kt
package com.example.bottomnavbar.view.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.R
import com.example.bottomnavbar.models.Forum

class ForumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
    private val contentTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

    fun bind(forum: Forum) {
        titleTextView.text = forum.title
        contentTextView.text = forum.description
        // Ajoutez d'autres vues au besoin
    }
}
