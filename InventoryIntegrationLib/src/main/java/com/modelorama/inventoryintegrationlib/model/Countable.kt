package com.modelorama.inventoryintegrationlib.model

interface Countable {
    fun getSkuId(): String
    fun getName(): String
    fun getDescription(): String
    fun getStock(): Int
}