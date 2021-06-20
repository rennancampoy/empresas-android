package com.example.empresas_android.data.dataPersistence

interface IPairDataPersistence {
    fun putStringSet(key: String, value: Set<String>)
    fun putString(key: String, value: String)
    fun putBoolean(key: String, value: Boolean)
    fun putFloat(key: String, value: Float)
    fun putInt(key: String, value: Int)
    fun putLong(key: String, value: Long)

    fun getStringSet(key: String, default: Set<String>): Set<String>
    fun getString(key: String, default: String): String
    fun getBoolean(key: String, default: Boolean): Boolean
    fun getFloat(key: String, default: Float): Float
    fun getInt(key: String, default: Int): Int
    fun getLong(key: String, default: Long): Long

    fun all(): Map<String, *>
    fun clear()
    fun remove(key: String)
    fun contains(key: String): Boolean
}