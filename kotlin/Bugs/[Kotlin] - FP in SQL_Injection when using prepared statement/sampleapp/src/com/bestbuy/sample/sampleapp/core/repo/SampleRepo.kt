package com.bestbuy.sample.sampleapp.core.repo

import com.bestbuy.sample.sampleapp.config.DbConfigSampleApp
import com.bestbuy.sample.sampleapp.core.exception.QueryExecutionException
import com.bestbuy.sample.sampleapp.core.model.*
import com.bestbuy.sample.sampleapp.core.repo.sqls.SampleSqls
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.util.*
import javax.sql.DataSource
import kotlin.collections.ArrayList

@Repository
class SampleRepo : SampleSqls {
    @Autowired
    private lateinit var databaseProvider: DbConfigSampleApp

    private fun connectionPoolDataSource(): DataSource? {
        return databaseProvider.getConnectionPoolDataSource()
    }

    fun getUniqueContextNames(requestId: String, ownerId: String?): List<String> {
        val contextList: MutableList<String> = ArrayList()
        val connection = connectionPoolDataSource()!!.connection
        val preparedStatement: PreparedStatement
        if (StringUtils.isEmpty(ownerId)) {
            preparedStatement = connection.prepareStatement(SQL_GET_DISTINCT_CONTEXT)
        } else {
            preparedStatement = connection.prepareStatement(SQL_GET_DISTINCT_CONTEXT_BY_OWNER)
            preparedStatement.setString(1, ownerId)
        }
        try {
            val resultSet = preparedStatement.executeQuery()

            while (resultSet.next()) {
                val context = resultSet.getString(COLUMN_CONTEXT)
                contextList.add(context)
            }

            // will be reused for next SQL
            resultSet.close()
            preparedStatement.close()

        } catch (exception: Exception) {
            throw QueryExecutionException(
                String.format(
                    "SampleRepo getUniqueContextNames(): Exception when executing getUniqueContextNames, Detail: %s",
                    exception.message
                )
            );
        } finally {
            if (!connection.isClosed) {
                connection.close()
            }
            if (!preparedStatement.isClosed) {
                preparedStatement.close()
            }
        }
        return contextList
    }
}

