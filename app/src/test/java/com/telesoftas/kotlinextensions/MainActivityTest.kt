package com.telesoftas.kotlinextensions

import org.junit.Assert.*
import org.junit.Test

class MainActivityTest {

    @Test
    fun isNull() {
        val notNull = Any()
        val isNull = null

        assertFalse(notNull.isNull())
        assertTrue(isNull.isNull())
    }

    @Test
    fun intYoDate() {
        val dateInt = 1598435781

        assertEquals(dateInt, dateInt.toDate().time.toSeconds())
    }

    @Test
    fun dateToString_stringToDate() {
        val dateString = "2020-05-15 13:20:15"

        val format = "yyyy-MM-dd HH:mm:ss"

        assertEquals(dateString, dateString.toDate(format)?.toString(format))
    }

    @Test
    fun toPrice() {
        val price = 123456789.5.toPrice()

        assertEquals("€123,456,789.50", price)
    }

    @Test
    fun containsDigits() {
        assertTrue("153".containsDigit)
        assertTrue("15s30".containsDigit)
        assertFalse("asc".containsDigit)
    }

    @Test
    fun isAlphanumeric() {
        assertTrue("153".isAlphanumeric)
        assertTrue("15s30".isAlphanumeric)
        assertTrue("asc".isAlphanumeric)
        assertFalse("asc2@".isAlphanumeric)
    }

    @Test
    fun IsEmailValid() {
        assertTrue("test@gmail.com".isEmailValid())
        assertFalse("test@gmail".isEmailValid())
        assertFalse("testgmail.com".isEmailValid())
        assertFalse("@gmail.com".isEmailValid())
    }

    @Test
    fun lastPathComponent() {
        val path = "path"
        val path1 = "path/secondComponent"
        val path2 = "path/secondPath/thirdComponent"

        assertEquals(path, path.lastPathComponent)
        assertEquals("secondComponent", path1.lastPathComponent)
        assertEquals("thirdComponent", path2.lastPathComponent)
    }
}