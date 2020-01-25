package com.example.zetaapp.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.zetaapp.R
import com.example.zetaapp.models.SearchResult
import com.example.zetaapp.network.SearchApi
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel : SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //return DataBindingUtil.inflate<FragmentSearchBinding>(inflater, R.layout.fragment_search, container, false)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var searchInput : String = ""


        btnSearch.setOnClickListener {
           searchInput = etSearch.text.toString()
        }

        searchViewModel = ViewModelProviders.of(this, ViewModelProviderFactory(searchApi = SearchApi.invoke(), searchText = searchInput)).get(SearchViewModel::class.java)
        subscribeObservers()

    }

    private fun subscribeObservers() {
        searchViewModel.observeSearchResults().removeObservers(viewLifecycleOwner)
        searchViewModel.observeSearchResults().observe(viewLifecycleOwner,
            Observer<SearchResult> {
                Log.d("onChanged","called")
                //todo pass result to next fragment
            })

    }
}
