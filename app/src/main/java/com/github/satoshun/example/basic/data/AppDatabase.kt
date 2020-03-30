package com.github.satoshun.example.basic.data

import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
  entities = [
    Animal::class,
    Vehicle::class
  ],
  version = 2
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun animalDao(): AnimalDao
  abstract fun vehicleDao(): VehicleDao
}

@VisibleForTesting
val MIGRATION_1_2: Migration = object : Migration(1, 2) {
  override fun migrate(database: SupportSQLiteDatabase) {
    database.execSQL("CREATE TABLE IF NOT EXISTS `vehicle` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL)")
  }
}
