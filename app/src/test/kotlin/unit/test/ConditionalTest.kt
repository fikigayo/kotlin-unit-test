package unit.test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.condition.*

class ConditionalTest {
    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX])
    fun enabledOnWindowsOrLinux(){
        // only run on windows or linux
    }

    @Test
    @DisabledOnOs(value = [OS.MAC, OS.WINDOWS])
    fun disabledOnMacAndWindows(){
        // cant run on Mac
    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_16])
    fun onlyRunOnJava16(){
        // cant run on Mac
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_13, max = JRE.JAVA_16)
    fun disabledRunOnJava16AndOther(){
        // cant run on Mac
    }

    @Test
    fun printSystemProperties(){
        System.getProperties().forEach{key,value->
            println("$key -> $value")
        }
    }

    @Test
    // -------more than 1
    @EnabledIfSystemProperties(value = [
        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation"),
//        EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation"),
    ])
    // ------only than 1
//    @EnabledIfSystemProperties(EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation"))
    fun enabledOnOracle(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun enabledOnDev(){

    }
    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun disabledOnDev(){

    }
}