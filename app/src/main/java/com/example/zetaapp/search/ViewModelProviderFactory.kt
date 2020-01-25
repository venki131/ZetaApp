package com.example.zetaapp.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zetaapp.network.SearchApi

class ViewModelProviderFactory (
    private val searchApi: SearchApi,
    private val searchText : String
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(this.searchApi, searchText) as T
    }
}