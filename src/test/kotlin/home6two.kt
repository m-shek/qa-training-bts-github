import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

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

