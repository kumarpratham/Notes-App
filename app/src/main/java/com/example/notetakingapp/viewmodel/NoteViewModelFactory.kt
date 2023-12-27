package com.example.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notetakingapp.database.Repository

class NoteViewModelFactory(val app : Application, private val repo : Repository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(NoteViewModel::class.java)){
            return NoteViewModel(app,repo) as T
        }
        throw IllegalArgumentException("Unknown view model found!!")
    }
}