package com.modelorama.inventoryintegrationlib.model

class Item constructor(
    private var skuId: String,
    private var name: String,
    private var description: String,
    private var stock: Int
) : Countable {

    override fun getSkuId(): String = skuId

    override fun getName(): String = name

    override fun getDescription(): String = description

    override fun getStock(): Int = stock
}