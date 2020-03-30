package com.github.satoshun.example.basic.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
  entities = [
    Animal::class,
    Vehicle::class
  ],
  version = 1)
abstract class AppDatabase : RoomDatabase() {
  abstract fun animalDao(): AnimalDao
  abstract fun vehicleDao(): VehicleDao
}
