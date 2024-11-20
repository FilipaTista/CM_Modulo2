package com.example.mywatchlist.model

data class WatchListItem(
    val id: Int,
    val title: String,
    val type: String, // "Movie" or "Series"
    var isWatched: Boolean = false
)
