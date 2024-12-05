package org.reading.smart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.reading.smart.viewmodel.UserViewModel

@Composable
fun App() {
    MaterialTheme {
        MainContent(userViewModel = UserViewModel())
    }
}

@Composable
fun MainContent(userViewModel: UserViewModel){
    val users by userViewModel.users.collectAsState()

    userViewModel.loadUsers()
    Box(modifier = Modifier.background(Color.White).fillMaxSize()){
        LazyColumn(modifier = Modifier.padding(8.dp)) {
            items(users){ user ->
                Row {
                    Text(text = user.name, fontSize = 12.sp)
                    Text(text = user.email, fontSize = 12.sp)
                    Text(text = user.postCount.toString(), fontSize = 12.sp)
                }
            }
        }
    }

}