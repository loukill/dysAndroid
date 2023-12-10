// ForumDiffCallback.kt
package com.example.bottomnavbar.view.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.bottomnavbar.models.Forum

class ForumDiffCallback : DiffUtil.ItemCallback<Forum>() {
    override fun areItemsTheSame(oldItem: Forum, newItem: Forum): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Forum, newItem: Forum): Boolean {
        return oldItem == newItem
    }
}
