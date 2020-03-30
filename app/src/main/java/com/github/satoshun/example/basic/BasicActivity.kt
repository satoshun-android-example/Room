package com.github.satoshun.example.basic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.github.satoshun.example.R
import com.github.satoshun.example.basic.data.Animal
import com.github.satoshun.example.basic.data.AppDatabase
import com.github.satoshun.example.basic.data.MIGRATION_1_2
import com.github.satoshun.example.basic.data.Vehicle
import com.github.satoshun.example.databinding.BasicActBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class BasicActivity : AppCompatActivity() {
  private lateinit var binding: BasicActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.basic_act)
    binding = BasicActBinding.bind(getContentView())

    val database = Room
      .databaseBuilder(this, AppDatabase::class.java, "test")
      .addMigrations(MIGRATION_1_2)
      .build()

    val dao = database.animalDao()
    dao.getAnimals()
      .onEach { println("$it") }
      .launchIn(lifecycleScope)

    var id = 0
    binding.basic.setOnClickListener {
      lifecycleScope.launch {
        id += 1
        dao.addAnimal(Animal(name = "hoge $id"))
      }
    }

    val vehicleDao = database.vehicleDao()
    vehicleDao.getVehicles()
      .onEach { println("$it") }
      .launchIn(lifecycleScope)

    binding.vehicle.setOnClickListener {
      lifecycleScope.launch {
        vehicleDao.addVehicle(Vehicle(name = "hoge $id"))
      }
    }
  }
}
