package com.example.empresas_android.data.dataPersistence

import android.content.Context

class PairDataPersistence(context: Context, fileName: String = "DEFAULT"): IPairDataPersistence {

    private val sharedPreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    override fun putStringSet(key: String, value: Set<String>) {
        sharedPreferences.edit().putStringSet(key, value).apply()
    }

    override fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    override fun putFloat(key: String, value: Float) {
        sharedPreferences.edit().putFloat(key, value).apply()
    }

    override fun putInt(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }

    override fun putLong(key: String, value: Long) {
        sharedPreferences.edit().putLong(key, value).apply()
    }

    override fun getStringSet(key: String, default: Set<String>): Set<String> {
        return sharedPreferences.getStringSet(key, default)!!
    }

    override fun getString(key: String, default: String): String {
        return sharedPreferences.getString(key, default)!!
    }

    override fun getBoolean(key: String, default: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, default)
    }

    override fun getFloat(key: String, default: Float): Float {
        return sharedPreferences.getFloat(key, default)
    }

    override fun getInt(key: String, default: Int): Int {
        return sharedPreferences.getInt(key, default)
    }

    override fun getLong(key: String, default: Long): Long {
        return sharedPreferences.getLong(key, default)
    }

    override fun all(): MutableMap<String, *> = sharedPreferences.all

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    override fun remove(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }
}