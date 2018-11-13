import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.matchers.types.shouldNotBeTypeOf
import io.kotlintest.specs.DescribeSpec


fun actionsCollectEl (collection: Collection<Int>,operation: String, const:Int):Collection<Int>{
    val collection2 = mutableListOf<Int>()

    for(i in 0..collection.size-1){
        collection2.add(i,
                when (operation){
                    "plus" -> (collection.elementAt(i)+ const)
                    "minus" -> (collection.elementAt(i)- const)
                    "multiply" -> (collection.elementAt(i)* const)
                    "division"->(collection.elementAt(i)/ const)
                    else -> (collection.elementAt(i))
                })
    }
    return collection2
}


class Inline_map :DescribeSpec({
    describe("Inline funtction in collection "){
        val collection= listOf<Int>(2,4,7,9, 88, 65, 44, 78, 56)
        val const=28
        it("Check input data"){
            collection.shouldNotBeEmpty()
            collection.shouldNotBeTypeOf<Int>()
            const.shouldBeTypeOf<Int>()
        }

        context("Call function 'Collection + constant'"){
            val plus_result= actionsCollectEl(collection,"plus",const) == collection.map{it + const}
            it ("Check plus on true"){
                plus_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection - constant'"){
            val minus_result= actionsCollectEl(collection,"minus",const) == collection.map{it - const}
            it ("Check minus on true"){
                minus_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection multiply constant'"){
            val multiply_result= actionsCollectEl(collection,"multiply",const) == collection.map{it * const}
            it ("Check multiply on true"){
                multiply_result.shouldBeTrue()
            }
        }

        context("Call function 'Collection division constant'"){
            val division_result= actionsCollectEl(collection,"division",const) == collection.map{it / const}
            it ("Check multiply on true"){
                division_result.shouldBeTrue()
            }
        }
        context("Call function 'Collection with any constant'"){
            val any_result= actionsCollectEl(collection,"any",const) == collection.map{it}
            it ("Check multiply on true"){
                any_result.shouldBeTrue()
            }
        }

    }
})