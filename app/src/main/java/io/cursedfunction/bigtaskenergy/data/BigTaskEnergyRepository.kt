package io.cursedfunction.bigtaskenergy.data

import io.cursedfunction.bigtaskenergy.data.local.database.BigTaskEnergyDao
import io.cursedfunction.bigtaskenergy.data.local.database.BigTaskModel
import io.cursedfunction.bigtaskenergy.di.ApplicationScope
import io.cursedfunction.bigtaskenergy.di.DefaultDispatcher
import io.cursedfunction.bigtaskenergy.domain.data.BigTask
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface BigTaskEnergyRepository {
    suspend fun createTask(title: String, description: String): Long
    suspend fun getAllTasks(): List<BigTask>
}

class DefaultBigTaskEnergyRepository @Inject constructor(
    private val bigTaskEnergyDao: BigTaskEnergyDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationScope private val scope: CoroutineScope
) : BigTaskEnergyRepository {

    override suspend fun createTask(title: String, description: String): Long {
        val taskId = withContext(dispatcher) {
            bigTaskEnergyDao.upsertTask(
                BigTaskModel(
                    title = title,
                    description = description,
                    isCompleted = false
                )
            )
        }

        return taskId
    }

    override suspend fun getAllTasks(): List<BigTask> {
        return withContext(dispatcher) {
            bigTaskEnergyDao.fetchAll().toModelList()
        }
    }
}
