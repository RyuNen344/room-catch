package com.ryunen344.room.column.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.ryunen344.room.column.db.entity.FloatEntity
import com.ryunen344.room.column.db.entity.IntegerEntity
import com.ryunen344.room.column.db.entity.LongEntity
import com.ryunen344.room.column.db.entity.StringEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CatchDao {
    @Query("SELECT * FROM floatentity")
    abstract fun selectFloat(): Flow<List<FloatEntity>>

    @Query("SELECT * FROM integerentity")
    abstract fun selectInteger(): Flow<List<IntegerEntity>>

    @Query("SELECT * FROM longentity")
    abstract fun selectLong(): Flow<List<LongEntity>>

    @Query("SELECT * FROM stringentity")
    abstract fun selectString(): Flow<List<StringEntity>>
}
