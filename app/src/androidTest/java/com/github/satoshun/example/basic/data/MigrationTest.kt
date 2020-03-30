package com.github.satoshun.example.basic.data

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MigrationTest {
  @Rule
  val migrationTestHelper = MigrationTestHelper(InstrumentationRegistry.getInstrumentation(),
    AppDatabase::class.java.canonicalName,
    FrameworkSQLiteOpenHelperFactory())

  @Before
  fun setUp() {
  }
}
