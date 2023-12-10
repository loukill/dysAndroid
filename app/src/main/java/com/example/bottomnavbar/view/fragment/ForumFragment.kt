package com.example.bottomnavbar.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavbar.R
import com.example.bottomnavbar.adapters.ForumAdapter
import com.example.bottomnavbar.network.ForumService
import com.example.bottomnavbar.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.bottomnavbar.viewmodel.ForumViewModel

class ForumFragment : Fragment() {

    private lateinit var forumAdapter: ForumAdapter
    private lateinit var forumApiService: ForumService
    private lateinit var recyclerView: RecyclerView
    private val viewModel: ForumViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forum, container, false)

        recyclerView = view.findViewById(R.id.rvforum)
        recyclerView.adapter = ForumAdapter(emptyList(),viewModel, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize Retrofit service
        forumApiService = RetrofitClient().retrofit.create(ForumService::class.java)

        // Fetch forum data from the API
        fetchForumData()

        return view
    }

    private fun fetchForumData() {
        // Utilisation de lifecycleScope.launch pour effectuer l'appel réseau dans un coroutine
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val response = forumApiService.getAllForums()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        forumAdapter = response.body()?.let { ForumAdapter(it, viewModel, this@ForumFragment) }!!
                        recyclerView.adapter = forumAdapter
                    } else {
                        // Handle API error
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Handle network failure
            }
        }

    }

    private fun navigateToForumDetail(forumId: String) {
        // TODO: Implémentez la logique de navigation vers ForumDetailActivity ou ForumDetailFragment
        // Passez le forumId à l'écran de détails
        // Vous pouvez utiliser Intent ou FragmentTransaction en fonction de votre méthode de navigation
    }
}
