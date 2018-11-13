package stepic

import io.kotlintest.specs.DescribeSpec

fun div_2_2 (collection: Collection<Int>):Collection<Int>{
    val collection2 = mutableListOf<Int>()

    for( i in 0..collection.size-1) {
        collection2.add(i, (collection.elementAt(i) / 2))
    }
    return collection2
}
class div_chek:DescribeSpec({
    describe("Function div 2"){
        val collection= listOf<Int>(2,4,7,9)
        context("Call function div 2"){
            div_2_2(collection)==collection.map { it/2 }
            it ("Проверки"){
            }
        }
    }
})