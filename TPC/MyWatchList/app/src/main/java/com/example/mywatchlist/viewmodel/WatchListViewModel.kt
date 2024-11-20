package com.example.mywatchlist.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mywatchlist.model.WatchListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WatchListViewModel : ViewModel() {
    private val _watchList = MutableStateFlow(listOf(
        WatchListItem(1, "Stranger Things", "Series"),
        WatchListItem(2, "Inception", "Movie")
    ))
    val watchList: StateFlow<List<WatchListItem>> = _watchList.asStateFlow()

    fun addItem(item: WatchListItem) {
        _watchList.value += item
    }

    fun removeItem(item: WatchListItem) {
        _watchList.value -= item
    }

    fun toggleWatchedStatus(item: WatchListItem) {
        _watchList.value = _watchList.value.map {
            if (it.id == item.id) it.copy(isWatched = !it.isWatched) else it
        }
    }
}