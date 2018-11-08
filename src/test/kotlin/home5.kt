import io.kotlintest.matchers.numerics.shouldBeGreaterThanOrEqual
import io.kotlintest.matchers.numerics.shouldBeInRange
import io.kotlintest.matchers.numerics.shouldBeLessThanOrEqual
import io.kotlintest.matchers.numerics.shouldNotBeGreaterThanOrEqual
import io.kotlintest.shouldBe
import io.kotlintest.specs.DescribeSpec

fun RandomNumber_ (from: Int, to: Int): Int {
    return (Math.random() * (to - from) + from).toInt()
}

fun ArrayRandomNumbers (size:Int, RandomNumber_: Int):MutableList<String> = (MutableList (size) {RandomNumber_.toString()})



fun check_polindrom(number :String): Boolean {
    var rotateNumber = 0
    var  temp = number.toInt()

    while (temp !=0){
        rotateNumber = rotateNumber *10 + temp % 10
        temp /= 10
    }
    if ((number.toInt() == rotateNumber) && (number.toInt() > 0)) return  true
    else return false
}

fun check_listofpolidromnumber (numbers: MutableList<String>):Int {
    var count = numbers.count()
    var count_polidrom =0
    for (i in 0 until count){
        var number=numbers[i]
        var check =check_polindrom(number)
        if (check == true ) {
            count_polidrom +=1
        }
        else count_polidrom
    }
    return count_polidrom
}



class Home5 : DescribeSpec({
    describe("Checks number on palindrome ") {

        var polidrom_number =RandomNumber_ (-114411, 114412)
        var input_polidrom = ArrayRandomNumbers(1,polidrom_number)
        it ("Check input data"){
            polidrom_number.shouldBeGreaterThanOrEqual(-2147483648)
            polidrom_number.shouldBeLessThanOrEqual(2147483647)
            input_polidrom.size.shouldBeGreaterThanOrEqual(0)
        }

        context("Check Random Number") {

            check_listofpolidromnumber(input_polidrom).shouldBeGreaterThanOrEqual(0)
            println ("Проверка рандомного числа, количество палиндромов ${input_polidrom} , ${check_listofpolidromnumber(input_polidrom)}")

            it("Two-digit palindrome") {
                val two = mutableListOf<String>("11","22","33", "44", "55", "66", "77", "88", "99")
                check_listofpolidromnumber(two) shouldBe (two.size)
                println ("Статичная положительная проверка 2 знач-х палиндромов ${check_listofpolidromnumber(two)}")
            }


            it("Positive.Three-digit palindrome ") {
                val three = mutableListOf<String>("181","191","373", "787", "919", "676", "787", "818", "919","545")
                check_listofpolidromnumber(three) shouldBe three.size
                println ("Статичная положительная проверка 3знач-х палиндромов ${check_listofpolidromnumber(three)}")
            }


            it("Positive.Four-digit palindrome ") {
                val four = mutableListOf<String>("1881","5445","8008", "7887", "9119", "6226", "7337", "8888", "9119","2552", "8008")
                check_listofpolidromnumber(four) shouldBe four.size
                println ("Статичная положительная проверка 4знач-х палиндромов  ${check_listofpolidromnumber(four)}")
            }


            it("Positive.Five-digit palindrome ") {
                val five = mutableListOf<String>("18181","54145","80108", "78687", "91319", "62026", "73237", "88888", "91019","25452", "80308" ,"97079")
                check_listofpolidromnumber(five) shouldBe five.size
                println ("Статичная положительная проверка 5знач-х палиндромов  ${check_listofpolidromnumber(five)}")
            }


            it("Positive.six-digit palindrome ") {
                val six = mutableListOf<String>("181181","541145","801108", "786687", "913319", "620026", "732237", "888888", "910019","254452", "803308" ,"970079" ,"876678")
                check_listofpolidromnumber(six) shouldBe six.size
                println ("\"Статичная положительная проверка 6знач-х палиндромов  ${check_listofpolidromnumber(six)}")
            }


            it("Positive.Seven-digit palindrome ") {
                val seven = mutableListOf<String>("1817181","5418145","8013108", "7862687", "9131319", "6208026", "7324237", "8888888", "9198919","2546452", "8030308" ,"9700079" ,"1115111","1234321")
                check_listofpolidromnumber(seven) shouldBe seven.size
                println ("Статичная положительная проверка 7знач-х палиндромов  ${check_listofpolidromnumber(seven)}")
            }


            it("Positive.Eigth-digit palindrome ") {
                val eight = mutableListOf<String>("18177181","54188145","80133108", "78622687", "91311319", "62088026", "73244237", "88888888", "91988919","25466452", "80300308" ,
                        "97000079" ,"76533567" , "78788787" ,"32455423")
                check_listofpolidromnumber(eight) shouldBe eight.size
                println ("Статичная положительная проверка 8знач-х палиндромов  ${check_listofpolidromnumber(eight)}")
            }


            it("Positive.Nine-digit palindrome ") {
                val nine = mutableListOf<String>("181767181","541878145","801333108", "786222687", "913111319", "620838026", "732454237", "888888888", "919898919","254606452", "803010308" ,
                        "970000079" ,"765353567" , "787878787" ,"324595423","198767891")
                check_listofpolidromnumber(nine) shouldBe nine.size
                println ("Статичная положительная проверка 9 знач-х палиндромов  ${check_listofpolidromnumber(nine)}")
            }


            it("Positive.Ten-digit palindrome ") {
                val ten = mutableListOf<String>("1817667181","1418778141","1801331081", "1786226871", "1913113191", "1620880261", "1732442371", "1888888881", "1919889191","1254664521", "1803003081" ,
                        "2140000412" ,"2147447412" , "1787887871" ,"1324554231","2138778312" ,"2134774312")
                check_listofpolidromnumber(ten) shouldBe ten.size
                println ("Статичная положительная проверка 10 знач-х палиндромов  ${check_listofpolidromnumber(ten)}")
            }


            it("Negative. palindrome ") {
                val negative = mutableListOf<String>("-1817667181","-11","-22", "181101", "5438145", "78632687", "31", "1913213191", "1919","1888808881")
                check_listofpolidromnumber(negative) shouldBe 0
                println ("Негативная проверка чисел, не являющихся палиндромами ${check_listofpolidromnumber(negative)}")
            }
        }
    }
})
