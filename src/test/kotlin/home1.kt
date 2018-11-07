import io.kotlintest.matchers.collections.shouldHaveSize
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.numerics.shouldBeInRange
import io.kotlintest.matchers.numerics.shouldBePositive
import io.kotlintest.matchers.numerics.shouldNotBeLessThan
import io.kotlintest.matchers.string.shouldNotBeEmpty
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.specs.DescribeSpec

class FirstHomework : DescribeSpec({
        describe("Checks on multiple condition") {
            context( "Function for multiple condition") {
                it( " Multiple condition for score") {
                    val score = RundomValues(1,10)

                    score.shouldBeTypeOf<Int>()
                    score.shouldNotBeLessThan(1)
                    score.shouldBePositive()
                    score.shouldBeInRange(1..10)
                    grade(score).shouldBeTypeOf<String>()
                    grade(score).shouldNotBeEmpty()
                }
            }

            context ("Array of integer") {
                it("Checks for integer sum"){
                    val size = 4
                    val intCollection: MutableList<Int> = OutputValues(size)
                    size.shouldBePositive()
                    size.shouldBeTypeOf<Int>()
                    size.shouldNotBeLessThan(2)
                    intCollection.shouldNotBeEmpty()
                    intCollection.shouldHaveSize(size)
                    intCollection.elementAt(1).shouldBePositive()
                    sumIntColletions(intCollection).shouldBeTypeOf<Int>()
                    sumIntColletions(intCollection).shouldBePositive()
                    sumIntColletions(intCollection).shouldNotBeLessThan(1)
                }
            }

        }
    })

    fun RundomValues (from: Int, to: Int): Int {
        return (Math.random() * (to - from) + from).toInt()
    }

    fun OutputValues (size:Int):MutableList<Int> = (MutableList (size) {RundomValues(0 , 10 )})

    fun  grade (score: Int ) = when (score) {
        9, 10 -> "Excellent"
        in 6..8 -> "Good"
        4, 5 -> "OK"
        in 1..3 -> "Fail"
        else -> "Fail"
    }


    fun sumIntColletions ( intCollection: MutableCollection<Int>):Int {
        var summ = 0
        for (i in intCollection) {
            summ += i
        }
        return summ

}