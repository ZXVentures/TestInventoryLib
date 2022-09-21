package com.modelorama.inventoryintegrationlib.businesslogic

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.modelorama.inventoryintegrationlib.model.Countable
import com.modelorama.inventoryintegrationlib.model.Item


public class StockAdmin constructor(private val context: Context) {
    fun getStock(): ArrayList<Countable> {
        //TODO connect to repository
        var uri: Uri =
            Uri.parse("content://com.modelorama.inventorymanagement.test.provider.products/products")

        var cursor: Cursor? = context.contentResolver.query(uri, null, null, null, null)

        var items = ArrayList<Countable>()
        var msg = "No existen datos"
        if (cursor != null && cursor.count > 0) {
            msg = "Existen %d$cursor.count datos"


            while (cursor.moveToNext()) {
                var skuIdIndex: Int = cursor.getColumnIndex("sku_id")
                var nameIndex: Int = cursor.getColumnIndex("name")
                var inventoryIndex: Int = cursor.getColumnIndex("inventory")
                var quantityIndex: Int = cursor.getColumnIndex("quantity")

                var skuId: String = cursor.getString(skuIdIndex)
                var name: String = cursor.getString(nameIndex)
                var stock: Int = cursor.getInt(inventoryIndex)
                var quantity: Int = cursor.getInt(quantityIndex)

                items.add(Item(skuId, name, skuId + name, stock))

                Log.i(
                    "InventoryIntegration",
                    "el  item: $skuId-$name, tiene stock:$stock"
                )
            }

        }
        return items
    }
}