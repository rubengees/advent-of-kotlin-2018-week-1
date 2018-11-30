package com.rubengees.pathfinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Ruben Gees
 */
class OutputMarkerTest {

    private val outputMarker = OutputMarker()

    @Test
    fun `formatting input should return correct result`() {
        val input = """
        ....................
        .........XS.........
        ....................
        """.trimIndent()

        val marked = """
        ....................
        .........**.........
        ....................
        """.trimIndent()

        val path = listOf(Coordinate(9, 1), Coordinate(10, 1))

        assertEquals(marked, outputMarker.mark(input, path))
    }
}