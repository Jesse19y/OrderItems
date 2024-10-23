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
}