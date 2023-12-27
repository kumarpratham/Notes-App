package com.example.notetakingapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notetakingapp.model.Note

@Database(
    entities = [Note::class], version = 1
)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun getNoteDao() : NoteDao

    companion object {
        @Volatile
        private var INSTANCE : NoteDatabase ?= null
        private val LOCK =  Any()

        operator fun invoke(context: Context) = INSTANCE ?:
            synchronized(LOCK){
                INSTANCE ?:
                createDatabase(context).also{
                    INSTANCE = it
                }
            }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "note_db"
        ).build()
    }

}