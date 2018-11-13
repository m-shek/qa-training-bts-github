import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

fun binaryv0 (c:String, d:String):String{
    val c1=c.toInt(2)
    val d1=d.toInt(2)
    val sum:String =(c1.plus(d1).toString(2))
    return sum
}

/*
fun binarv1 (c:String, d:String) :String {
    var e:MutableList<String> = mutableListOf()
    for (i in 0..c.length-1) {
        when {
            ((c.get(i) == '0') and (d.get(i) == '0')) -> e.add(i, "0")
            ((c.get(i) == '0') and (d.get(i) == '1')) -> e.add(i,"1")
            ((c.get(i) == '1') and (d.get(i) == '0')) -> e.add(i,"1")
            ((c.get(i) == '1') and (d.get(i) == '1')) -> e.add(i,"10")
        }
    }
    var sr_res=""
    println("$e")

    for (j in e.lastIndex downTo  0){
        sr_res= e[j]+sr_res
    }

    var sr1 = sr_res
    return sr1
}

*/

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
            val result= binaryv0(c,d)

            it ("Проверка выполнения функции") {
                result.shouldBe("1010")
                result.contains('0') ||result.contains('0')

                binaryv0(c,d) shouldBe ("1010")
                binaryv0("101","100") shouldBe ("1001")
                binaryv0("001", "001") shouldBe ("10")
                binaryv0("010","010") shouldBe("100")
                binaryv0("111", "110") shouldBe ("1101")
            }
        }
    }
})

