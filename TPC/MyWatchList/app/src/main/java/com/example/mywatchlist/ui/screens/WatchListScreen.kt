package com.example.mywatchlist.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mywatchlist.model.WatchListItem
import com.example.mywatchlist.viewmodel.WatchListViewModel

@Composable
fun WatchListScreen(viewModel: WatchListViewModel = viewModel()) {
    val watchList by viewModel.watchList.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.addItem(
                        WatchListItem(
                            id = watchList.size + 1,
                            title = "New Item",
                            type = "Movie"
                        )
                    )
                }
            ) {
                Text("+")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(watchList) { item ->
                WatchListItemRow(
                    item = item,
                    onToggleWatched = { viewModel.toggleWatchedStatus(it) },
                    onDelete = { viewModel.removeItem(it) }
                )
            }
        }
    }
}

@Composable
fun WatchListItemRow(
    item: WatchListItem,
    onToggleWatched: (WatchListItem) -> Unit,
    onDelete: (WatchListItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = item.isWatched,
            onCheckedChange = { onToggleWatched(item) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "${item.title} (${item.type})",
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { onDelete(item) }) {
            Icon(Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}