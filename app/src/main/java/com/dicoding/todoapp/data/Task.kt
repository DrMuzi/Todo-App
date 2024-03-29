package com.dicoding.todoapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dicoding.todoapp.utils.TASK_TABLE_NAME

//TODO 1 : Define a local database table using the schema in app/schema/tasks.json
@Entity(tableName = TASK_TABLE_NAME)
data class Task(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @NonNull
    @ColumnInfo(name = "title")
    val title: String,

    @NonNull
    @ColumnInfo(name = "description")
    val description: String,

    @NonNull
    @ColumnInfo(name = "dueDateMillis")
    val dueDateMillis: Long,

    @NonNull
    @ColumnInfo(name = "completed")
    val isCompleted: Boolean = false
)