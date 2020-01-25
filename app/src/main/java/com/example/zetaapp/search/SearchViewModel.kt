package com.example.zetaapp.search

import androidx.lifecycle.*
import com.example.zetaapp.models.SearchResult
import com.example.zetaapp.network.SearchApi
import com.example.zetaapp.utils.UrlConstants
import io.reactivex.schedulers.Schedulers


class SearchViewModel(
    private val searchApi: SearchApi,
    private val searchInput : String
) : ViewModel() {

    private val _searchItems = MutableLiveData<SearchResult>()

    private val searchText = MutableLiveData<String>()

    fun observeSearchResults() : LiveData<SearchResult> {

        _searchItems.value = null

        val source = LiveDataReactiveStreams.fromPublisher(
            searchApi.getSearchResults(searchInput, UrlConstants.CX_VALUE)
                .subscribeOn(Schedulers.io())
        )

        _searchItems.postValue(source.value)

        return _searchItems
    }

}