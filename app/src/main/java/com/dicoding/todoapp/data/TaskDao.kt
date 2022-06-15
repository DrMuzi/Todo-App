package com.dicoding.todoapp.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery


//Define data access object (DAO)
@Dao
interface TaskDao {
    @Query("SELECT * FROM task ORDER BY id ASC")
    fun getTasks(): LiveData<List<Task>>
    //fun getTasks(query: SupportSQLiteQuery): DataSource.Factory<Int, Task>

    @Query("SELECT * FROM task WHERE id=:taskId")
    fun getTaskById(taskId: Int): LiveData<Task>

    @Query("SELECT * FROM task ORDER BY dueDateMillis DESC")
    fun getNearestActiveTask(): Task

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task: Task): Long

    @Insert
    fun insertAll(vararg tasks: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Update
    suspend fun updateCompleted(taskId: Int, completed: Boolean)
    
}
