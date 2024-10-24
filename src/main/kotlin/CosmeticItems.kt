package org.example

class CosmeticItems{
    private val items = mutableMapOf(
        "face wash" to 25000, "body lotion" to 20000, "perfume" to 45000, "roll on" to 15000,
        "sun cream" to 50000, "shampoo" to 18500, "wax" to 15000, "body spray" to 15000
    )

    fun availableItem(){
        for((cosmeticItem, price) in items){
            println("$cosmeticItem- $price ks")
        }
    }

    private val cosmeticOrderList = mutableListOf<String>()
    private var total = 0

    fun orderItem(){
        println("Which item do you want? Enter q to quit and r to cancel order")
        var orderInput = readln().lowercase()

        while(orderInput != "q"){

            if(orderInput == "r"){
                orderCancel()
            }

            else if(items.containsKey(orderInput)){
                val price = items[orderInput]
                total += price!!
                cosmeticOrderList.add(orderInput)
                println("You ordered $orderInput-$price ks")
            }

            else{
                println("$orderInput isn't available right now!")
            }

            println("Which item do you want? Enter q to quit and r to cancel order")
            orderInput = readln().lowercase()
        }
    }

    private fun orderCancel(){
        println("Enter cancel item: ")
        val cancelOrder = readln().lowercase()

        if(cosmeticOrderList.contains(cancelOrder)){
            cosmeticOrderList.remove(cancelOrder)
            val price = items[cancelOrder]
            total -= price!!
            println("You cancel $cancelOrder")
        }

        else{
            println("$cancelOrder not in orderList")
        }
    }

    fun total(){
        println("Total Order: $cosmeticOrderList-$total ks")
    }
}