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
    // Room uses an own database hash to uniquely identify the database
    // Since version 1 does not use Room, it doesn't have the database hash associated.
    // By implementing a Migration class, we're telling Room that it should use the data
    // from version 1 to version 2.
    // If no migration is provided, then the tables will be dropped and recreated.
    // Since we didn't alter the table, there's nothing else to do here.
  }
}
