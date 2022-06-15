package com.dicoding.todoapp.data

//Define a local database table using the schema in app/schema/tasks.json

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "task")
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val dueDateMillis: Long,
    val isCompleted: Boolean = false
): Parcelable