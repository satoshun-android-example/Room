package com.github.satoshun.example.basic.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Animal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun animalDao(): AnimalDao
}
