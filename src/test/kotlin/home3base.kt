import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.numerics.shouldBeGreaterThan
import io.kotlintest.matchers.numerics.shouldBePositive
import io.kotlintest.matchers.numerics.shouldNotBeLessThanOrEqual
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.properties.verifyAll
import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.DescribeSpec


fun RandomDataN (from: Int, to: Int): Int {
    return (Math.random() * (to - from) + from).toInt()
}

fun OutputRandomN (size:Int):MutableList<String> = (MutableList (size) {RandomNumber(1 , 1000 ).toString()})

open class Engineer3 (var name:String, var department:String){
    open fun work(capacity: Int, currentTasks: MutableList<String>) {}
}

class Developer3 (name: String, department: String):Engineer3(name, department){
      override fun work(capacity: Int, currentTasks: MutableList<String>) {
          for (i in 0 until capacity) {
              currentTasks.add(currentTasks.last())
          }
      }
}
class QA3 (name: String, department: String):Engineer3(name, department){

    override fun work(capacity: Int,currentTasks: MutableList<String>) {
        for (i in 0 until capacity) {
            currentTasks.remove(currentTasks.last())
           }
    }

    fun releaseTesting(days:Int, feauters: Int, engineers:Int ): Boolean {
        val ost = 2*engineers*days- feauters
        if (ost>=0 || ost==0) {
            println("Релиз вовремя")
            return true
        }
            else {
                 println("Отмена релиза")
                return false
            }

        }
    }




class ChecksEmpTaskRelise3 : DescribeSpec({
    describe("Checks on reliseTesting") {
        var currentTasks = OutputRandomN(15)
        val capacity1 = RandomDataN(1, 3)
        var developer: Developer3 = Developer3("SimpleName", "SimpleDepartment")
        var tester: QA3 = QA3("SimpleQAName", "SimpleQADepartment")
        val days = RandomDataN(1, 14)
        val testersCount = RandomDataN(1, 2)

        context("Input Data_") {

           it("Проверим входные по списку задач") {
                currentTasks.isNotEmpty()
                currentTasks.size.shouldBeGreaterThan(0)
                currentTasks.size.shouldBePositive()
            }

            it("Проверим входные по количеству дней") {
                days.shouldBeTypeOf<Int>()
                days.shouldBePositive()
                days.shouldNotBe(0)
            }

            it("Проверим количество тестировщиков") {
                testersCount.shouldBeTypeOf<Int>()
                testersCount.shouldBePositive()
                testersCount.shouldNotBe(0)
            }
            it("Проверим увеличилось число задач после первого шага") {
                val currentTasks_size_before = currentTasks.size

                developer.work(capacity1, currentTasks)

                val step1 = currentTasks.size - capacity1
                step1.shouldBe(currentTasks_size_before)
            }
            it("Проверим увеличилось число задач после второго шага") {
                val currentTasks_size_before_step2 = currentTasks.size
                developer.work(capacity1, currentTasks)
                val step2 = currentTasks.size - capacity1
                step2.shouldBe(currentTasks_size_before_step2)
            }
            it("Проверим уменьшилось ли число задач после 3 шага") {
                val currentTasks_size_before_step3 = currentTasks.size
                tester.work(capacity1, currentTasks)
                val step3 = currentTasks.size + capacity1
                step3.shouldBe(currentTasks_size_before_step3)
            }
            it("Смогут ли тестировщики подготовить релиз") {
                currentTasks.isNotEmpty()
                tester.releaseTesting(days, currentTasks.size, testersCount)
            }
        }
    }

})

