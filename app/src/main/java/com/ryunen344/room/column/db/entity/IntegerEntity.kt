package com.ryunen344.room.column.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class IntegerEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    val key: Int
)
