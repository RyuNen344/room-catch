package com.ryunen344.room.column.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ryunen344.room.column.db.dao.CatchDao
import com.ryunen344.room.column.db.entity.FloatEntity
import com.ryunen344.room.column.db.entity.IntegerEntity
import com.ryunen344.room.column.db.entity.LongEntity
import com.ryunen344.room.column.db.entity.StringEntity

@Database(
    entities = [
        (FloatEntity::class),
        (IntegerEntity::class),
        (LongEntity::class),
        (StringEntity::class)
    ],
    version = 0,
    exportSchema = false
)
abstract class CacheDatabase : RoomDatabase() {
    abstract fun catchDao(): CatchDao
}
