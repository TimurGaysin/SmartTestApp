package org.reading.smart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.reading.smart.model.UserViewModel
import org.reading.smart.web.UserService

class UserViewModel(private var userService: UserService = UserService()) : ViewModel(){

    private val _users = MutableStateFlow<List<UserViewModel>>(emptyList())
    val users : StateFlow<List<UserViewModel>> = _users


    fun loadUsers(){
        viewModelScope.launch {
            val tempUsersList =  userService.fetchUsers().map {
                UserViewModel(it.id,it.name,it.email, -1)
            }
            _users.value = tempUsersList
            withContext(Dispatchers.IO){
                val updateUserList = tempUsersList.mapIndexed { _, element ->
                    val count = userService.getCountOfPostsByUserId(element.id)
                    element.copy(postCount = count)
                }
                _users.value = updateUserList
            }
        }
    }

}