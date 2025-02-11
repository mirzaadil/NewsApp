package com.arslan.home.data

import com.arslan.data.DataState
import com.arslan.home.datasource.remote.HomeRemoteDataSource
import com.arslan.home.model.TopHeadlines
import com.arslan.utils.CoroutineDispatchers
import com.arslan.utils.Dispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    @Dispatcher(CoroutineDispatchers.IO)
    private val ioDispatcher: CoroutineDispatcher,
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {
    override suspend fun getHeadlinesStream(): Flow<DataState<TopHeadlines>> =
        homeRemoteDataSource.getHeadlines().flowOn(ioDispatcher)


}