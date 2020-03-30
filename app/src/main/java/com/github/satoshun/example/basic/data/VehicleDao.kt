package com.github.satoshun.example.basic.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
  @Query("SELECT * FROM vehicle")
  fun getVehicles(): Flow<List<Vehicle>>
}


@Entity(tableName = "vehicle")
data class Vehicle(
  val name: String
) {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var id: Long = 0
}
