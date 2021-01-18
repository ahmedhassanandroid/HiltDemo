package com.nextwo.hiltapp.data.repo

import com.nextwo.hiltapp.data.source.DataSource
import com.nextwo.hiltapp.domain.repo.IDishesRepo
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class DishesRepoImpl @Inject constructor(
    private val dataSource: DataSource
): IDishesRepo {

    //indicated the number of the instance
    private val instanceNumber: Int
    init {
        instanceNumber = ++instancesCounter
    }

    override fun getDishes(): String {
        return "${dataSource.source} dishes $instanceNumber"
    }

    companion object {
        //incremented every instance created
        private var instancesCounter = 0
    }
}