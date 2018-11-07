import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.numerics.shouldBePositive
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec

open class Engineer(var name:String,department:String)

class QA (name: String, department: String):Engineer(name, department) {

    fun releaseTesting(days:Int=0, feauters:Int=0, engineers:Int=0): Boolean {
        val ost = 2*engineers*days - feauters
        when {
            ost == 0 -> {println("Успевают проверить день в день")
                        return true}
            ost >= 0 -> {println("Релиз будет, даже время останется")
                        return true}
            else -> {println("Все равно не успеем")
                        return false}
        }
}
}

class CheckFunction : DescribeSpec({
    describe("Проверка функции релиза") {
        val featuresForBuild = listOf<String>("Added button on main page","Fixed bug pagination","Added special character check","Fixed authorization error","Removed auto-complete password field", "Changed the message sending logic","New functionality, the ability to view photos")
        val fCount = featuresForBuild.size
        val days = 3
        val testers = 2

        it("Проверим входные по списку задач") {
            featuresForBuild.shouldNotBeEmpty()
            fCount.shouldBeTypeOf<Int>()
            fCount.shouldBePositive()
        }
        it("Проверим входные по количеству дней") {
          days.shouldBeTypeOf<Int>()
          days.shouldBePositive()
          days.shouldNotBe(0)
        }

        it("Проверим количество тестировщиков") {
          testers.shouldBeTypeOf<Int>()
          testers.shouldBePositive()
          testers.shouldNotBe(0)
        }

        context("Высчитываем количество сотрудников") {

            val c: Boolean = QA("df", "dfd").releaseTesting(days, fCount, testers)
            println("Количество дней= ${days}, Кол-во задач = ${fCount},Количесво тестер-в =${testers} , релиз = ${c} ")

            it("Проверка выходных данныx") {
                c.shouldBeTypeOf<Boolean>()


            }
        }
    }

})