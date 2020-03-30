package com.github.satoshun.example.basic.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {
  @Query("SELECT * FROM animal")
  fun getAnimals(): Flow<List<Animal>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun addAnimal(animal: Animal)
}

@Entity(tableName = "animal")
data class Animal(
  val name: String
) {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "id")
  var gardenPlantingId: Long = 0
}
