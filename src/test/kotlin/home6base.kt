import io.kotlintest.matchers.numerics.shouldBePositive
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

fun transV1(a: Int, b: Int) =Pair(b, a)

fun transV2(x: Int,y: Int):Result = Result((x+y)-x,(x+y)-y)


data class Result(val a: Int,val b:Int){}


class CheckFunction : DescribeSpec({
    describe("Определяем входные данные") {
        val a=3
        val b=4
        it ("Проверяем входные данные"){
            a.shouldBePositive()
            a.shouldBeTypeOf<Int>()
            b.shouldBePositive()
            b.shouldBeTypeOf<Int>()
        }

        context("Выполняем функцию подмены данных в полях") {

            val r1 = transV1(a,b)
            val r2 = transV2(a,b)

            it("Проверяем выходных данныx") {
                r1.first shouldBe b
                r1.second shouldBe a

                r2.a shouldBe b
                r2.b shouldBe a

            }
        }
    }

})