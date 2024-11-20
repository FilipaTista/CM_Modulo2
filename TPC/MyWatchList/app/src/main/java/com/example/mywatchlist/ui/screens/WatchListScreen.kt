package com.example.mywatchlist.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mywatchlist.model.WatchListItem
import com.example.mywatchlist.viewmodel.WatchListViewModel
import androidx.compose.runtime.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchListScreen(viewModel: WatchListViewModel = viewModel()) {
    val watchList by viewModel.watchList.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var newTitle by remember { mutableStateOf("") }
    var newType by remember { mutableStateOf("Movie") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Watch List") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    newTitle = ""
                    newType = "Movie"
                    showDialog = true
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)

        ) {
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Add New Item") },
                    text = {
                        Column {
                            TextField(
                                value = newTitle,
                                onValueChange = { newTitle = it },
                                label = { Text("Title") },
                                singleLine = true
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("Type:")
                                Spacer(modifier = Modifier.width(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = newType == "Movie",
                                        onClick = { newType = "Movie" }
                                    )
                                    Text("Movie")
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        selected = newType == "Series",
                                        onClick = { newType = "Series" }
                                    )
                                    Text("Series")
                                }
                            }
                        }
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                if (newTitle.isNotBlank()) {
                                    viewModel.addItem(
                                        WatchListItem(
                                            id = watchList.size + 1,
                                            title = newTitle,
                                            type = newType
                                        )
                                    )
                                    showDialog = false
                                }
                            }
                        ) {
                            Text("Add")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = { showDialog = false }
                        ) {
                            Text("Cancel")
                        }
                    }
                )
            }

            if (watchList.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Your watch list is empty",
                        style = MaterialTheme.typography.bodyLarge,

                        )
                }
            } else {
                LazyColumn {
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