// ForumAdapter.kt
package com.example.bottomnavbar.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.models.Forum
import com.example.bottomnavbar.R
import com.example.bottomnavbar.view.activities.ForumDetails
import com.example.bottomnavbar.view.fragment.ForumFragment
import com.example.bottomnavbar.view.viewholders.ForumViewHolder
import com.example.bottomnavbar.viewmodel.ForumViewModel

class ForumAdapter( val forums: List<Forum>, private val viewModel: ForumViewModel, private val lifecycleOwner: ForumFragment) : RecyclerView.Adapter<ForumViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForumViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_forum, parent, false)
        return ForumViewHolder(parent.context,view)
    }

    override fun onBindViewHolder(holder: ForumViewHolder, position: Int) {
        val forum = forums[position]
        holder.bind(forum)

//        // Ajoutez un clic sur le bouton pour chaque élément
//        holder.itemView.findViewById<ImageButton>(R.id.detailsButton).setOnClickListener {
//            val intent = Intent(context, ForumDetails::class.java)
//            intent.putExtra("forumTitle",forum.title)
//            intent.putExtra("description",forum.description)
//            intent.putExtra("forumImage",forum.image)
//
//            context.startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return forums.size
    }
}
