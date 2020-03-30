/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.satoshun.example.basic.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Helper class for creating the test database version 1 with SQLite.
 */
class SqliteTestDbOpenHelper(
  context: Context?,
  databaseName: String?
) : SQLiteOpenHelper(context, databaseName, null, DATABASE_VERSION) {
  override fun onCreate(db: SQLiteDatabase) {
    db.execSQL("CREATE TABLE users ( userid INTEGER  PRIMARY KEY, username TEXT )")
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    // Not required as at version 1
  }

  override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    // Not required as at version 1
  }

  companion object {
    const val DATABASE_VERSION = 1
  }
}