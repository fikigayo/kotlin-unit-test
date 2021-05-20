package unit.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assumptions.*
import org.junit.jupiter.api.assertThrows
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException

@DisplayName("Kalkulator kita")// Change Name
class CalculatorTest {
    //--------------- Before/After All ---------------------
    companion object{
        @BeforeAll
        @JvmStatic
        fun beforeAll(){
            println("sebelum semuaaaaaaa unit test")
        }

        @AfterAll
        @JvmStatic
        fun afterAll(){
            println("sebelum semuaaaaaaa unit test")
        }
    }

    //------------------Membuat Test---------------------

    private val calculator = Calculator()

    @Test
    @DisplayName("Test for function Calculator.add")// Change Name
    fun addTestSuccess(){
        val expected = 10
        assertEquals(expected, calculator.sum(3,7))
//        assertEquals(expected, calculator.sum(3,5),"contoh yang salah")
    }

    @Test
    fun addTestSuccess2(){
        println("unit test addTestSuccess2")
        val expected = 10
        assertEquals(expected, calculator.sum(3,7))
//        assertEquals(expected, calculator.sum(3,5),"contoh yang salah")
    }

    @Disabled("Coming Soon!")
    @Test
    fun addTestSuccess3(){
        val expected = 10
        assertEquals(expected, calculator.sum(3,7))
//        assertEquals(expected, calculator.sum(3,5),"contoh yang salah")
    }

    @Test
    fun divideTest(){
        val result = calculator.divide(100,10)
        assertEquals(10, result)
    }

    @Test
    fun divideTestFailed(){
        assertThrows<IllegalArgumentException>{
            calculator.divide(100,0)
            calculator.divide(100,10)//contoh yang salah
        }
    }
    //--------------- Before/After Each ---------------------
    @BeforeEach
    fun beforeEach(){
        println("sebelum unit test")
    }

    @AfterEach
    fun afterEach(){
        println("setelah unit test")
    }

    //--------------------- cancellation function --------------
    @Test
    fun testAborted(){
        val profile = System.getenv()["PROFILE"]
        if("DEV" != profile){
            throw  TestAbortedException()// CANCEL TEST
        }
        println("test not aborted")
    }

    @Test
    fun testAssumptions(){
        assumeFalse("DEV" == System.getenv()["PROFILE"])
        println("Test Not Aborted because Dev Profile")
//        Aborted Test
//        assumeTrue("DEV" == System.getenv()["PROFILE"])
    }

    //----------------------- Kondisi Sistem Operasi
}