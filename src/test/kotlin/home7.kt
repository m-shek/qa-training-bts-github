import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.matchers.types.shouldNotBeTypeOf
import io.kotlintest.specs.DescribeSpec



fun select_action (key:Int,x: Int,y:Int):Int =
        when (key) {
            1 ->  x + y
            2 ->  x - y
            3 ->  x * y
            4 ->  x / y
            else -> throw  Exception("Incorrect key")
        }

fun map2( collection: Collection<Int>, key:Int, const:Int):Collection<Int> {
    val collection2 = mutableListOf<Int>()

    for(i in 0..collection.size-1){
        collection2.add(i,select_action(key,collection.elementAt(i),const))
    }
    return collection2
}


class Inline_map : DescribeSpec({
    describe("Inline funtction in collection "){
        val collection= listOf<Int>(2,4,7,9,65,45,49, 44)
        val const=3
        it("Check input data"){
            collection.shouldNotBeEmpty()
            collection.shouldNotBeTypeOf<Int>()
            const.shouldBeTypeOf<Int>()
        }

        context("Call function 'Collection + constant'"){
            val plus_result= map2(collection,1, const) == collection.map{it + const}
            it ("Check plus on true"){
                plus_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection - constant'"){
            val minus_result= map2(collection, 2, const) == collection.map{it - const}
            it ("Check minus on true"){
                minus_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection * constant'"){
            val multiply_result= map2(collection, 3, const) == collection.map{it * const}
            it ("Check multiply on true"){
                multiply_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection / constant'"){
            val division_result= map2(collection, 4, const) == collection.map{it / const}
            it ("Check multiply on true"){
                division_result.shouldBeTrue()
            }
        }
    }
})


