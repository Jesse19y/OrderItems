package org.example

class Food {
    private val availableItems = mapOf("pizza" to 20, "hamburger" to 4, "coke" to 2)

    private fun items(){
        println("******Available Items list*******")
        for((item, price) in availableItems){
            println("$item = $price$")
        }
    }

    private val orderedItems = mutableListOf<String>()
    private var total: Int = 0
    fun orderItems(){
        println("Welcome my food store")
        println("May i take your order?\n if you want to quit enter 'Q'\n if you want to cancel order enter 'R'")
        items()

        var userInput = readln().lowercase()
        while(userInput != "q"){

            if(userInput == "r"){
                removeItems()
            }

            else if(availableItems.containsKey(userInput)){
                val price = availableItems[userInput]
                total += price!!
                orderedItems.add(userInput)
                println("You ordered $userInput")
            }

            else{
                println("$userInput isn't available")
            }

            userInput = readln().lowercase()
        }
    }

    private fun removeItems(){
        println("Item name to cancel order")
        val orderCancel = readln().lowercase()

        if(orderedItems.contains(orderCancel)){
            orderedItems.remove(orderCancel)
            val price = availableItems[orderCancel]
            total -= price!!
            println("You cancel $orderCancel")
        }

        else{
            println("$orderCancel isn't contains in order list")
        }
    }

    fun total(){
        println("You ordered $orderedItems and total price is $total$")
    }
}