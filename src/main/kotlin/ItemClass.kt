package org.example

class Order{
    private val items = mutableMapOf("pizza" to 25000, "ice-cream" to 2000,
                                                "donut" to 3000, "hotdog" to 3000, "coffee" to 4000,
                                                "tea" to 3000, "chocolate-cake" to 8000)


    fun availableItems(){
        println("These are available items in this cafe")
        for((item, price) in items){
            println("$item-$price ks")
        }
    }

    private val orderList = mutableListOf<String>()
    private var total = 0

    fun makeOrder(){
        println("Which food do you want? Enter q to quit, enter r to cancel item")
            var orderItem = readln().lowercase()

        while(orderItem != "q") {

            if (orderItem == "r") {
                cancelOrder()
            }

            else if (items.containsKey(orderItem)) {
                val price = items[orderItem]
                total += price!!
                orderList.add(orderItem)
                println("You ordered $orderItem-$price ks")
            }

            else {
                println("This $orderItem isn't available right now!")
            }

            println("Which food do you want? Enter q to quit, enter r to cancel item")
            orderItem = readln().lowercase()
        }
        println("Goodbye!")
    }

    fun totalCost(){
        println("Total cost amount: $total")
    }

    fun cancelOrder(){
        println("Enter item if you want to cancel: ")
        val cancelItem = readln().lowercase()
        if(orderList.contains(cancelItem)){
            orderList.remove(cancelItem)
            val price = items[cancelItem]
            total -= price!!
            println("You canceled $cancelItem")
        }else{
            println("$cancelItem not in order list")
        }
    }
}