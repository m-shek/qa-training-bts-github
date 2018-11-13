import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

fun binarv1 (c:String, d:String):String{
    val c1=c.toInt(2)
    val d1=d.toInt(2)
    val sum:String =(c1.plus(d1).toString(2))
    return sum
}


class binar:DescribeSpec ({
    describe( "Test Binar "){
        val c:String ="110"
        val d: String ="100"
        it("Проверяем входные данные"){
            c.length == d.length
            c.length > 0
            d.length > 0
        }
        context ("Складываем два числа "){
            val result= binarv1(c,d)

            it ("Проверка выполнения функции") {
                result.shouldBe("1010")
                result.contains('0') ||result.contains('0')

                binarv1("111","100") shouldBe ("1011")
                binarv1("011","100") shouldBe ("111")
                binarv1("010","010") shouldBe ("100")
                binarv1("001","001") shouldBe ("010")
            }
        }
    }
})

