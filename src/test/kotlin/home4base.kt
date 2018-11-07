import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.specs.DescribeSpec

fun StrTrueFalse (unicLett:String):Boolean {
    var unicLettStr = unicLett.toUpperCase().replace(" ", "")

  for (i in 0 until unicLettStr.length-1) {
      for (j in (i+1) until unicLettStr.length){
      if (unicLettStr[i]==(unicLettStr[j]))
          return false
        }
  }
      return true
     }

class Hw4easy :DescribeSpec({
describe("Preconditions, declare input parameters ") {
    var poz1var:String="Uniq"
    var poz2var:String="Q w E r T Y U I O P ["
    var neg1var:String="Not unique data"
    var nev2var:String="Negativ_ E"

    context ("Execution funcntion with positive results") {
        var poz1 = StrTrueFalse(poz1var)
        it("Positive case. Only Unigue letters") {
            poz1.shouldBeTrue()
        }
    }
    context("Positive case. With spaces") {
        var pos2 = StrTrueFalse(poz2var)
        it("Positive case. Unigue letters and space") {
            pos2.shouldBeTrue()
        }
    }
    context ("Execution function with negative results") {
        var neg1 = StrTrueFalse(neg1var)
        it("Negative case. Dublicate letters") {
            neg1.shouldBeFalse()
        }
    }
    context("Negative case 2. Duplicate characters (end and start))") {
        var neg2 = StrTrueFalse(nev2var)
        it("Negative case.Duplicate characters (end and start)") {
            neg2.shouldBeFalse()
        }
    }
}

})

