package com.example.notetakingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notetakingapp.database.Repository
import com.example.notetakingapp.model.Note
import kotlinx.coroutines.launch

class NoteViewModel(app : Application, private val noteRepository: Repository) : AndroidViewModel(app)
{
    fun addNote(note : Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }
    fun deleteNote(note : Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }
    fun updateNote(note : Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }
    fun getAllNotes() = noteRepository.getAllNote()
    fun searchNotes(query: String?) = noteRepository.searchNote(query)







}