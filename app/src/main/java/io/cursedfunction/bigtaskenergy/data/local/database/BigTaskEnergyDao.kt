package io.cursedfunction.bigtaskenergy.data.local.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface BigTaskEnergyDao {

    /**
     * Fetch all tasks
     *
     * @return a [List] of [BigTaskModel] if any exists, otherwise empty [List]
     */
    @Query("SELECT * FROM bigtasks")
    suspend fun fetchAll(): List<BigTaskModel>

    /**
     * Fetch a task by its ID
     *
     * @param taskId the task's ID
     * @return the task that matches the ID if it exists, otherwise null
     */
    @Query("SELECT * FROM bigtasks WHERE id = :taskId")
    suspend fun fetchTaskById(taskId: Long): BigTaskModel?

    /**
     * Insert or update a task stored in the database. If a task already exists, replace it
     *
     * @param task the [BigTaskModel] to be inserted or updated
     * @return the task ID if successful
     */
    @Upsert
    suspend fun upsertTask(task: BigTaskModel): Long

    /**
     * Update the completed status of a specific task
     *
     * @param taskId the ID of the task to update
     * @param completed status to be updated
     */
    @Query("UPDATE bigtasks SET isCompleted = :completed WHERE id = :taskId")
    suspend fun updateCompleted(taskId: Long, completed: Boolean)
}
