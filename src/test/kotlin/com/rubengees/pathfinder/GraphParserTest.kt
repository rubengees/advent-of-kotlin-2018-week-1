package com.rubengees.pathfinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * @author Ruben Gees
 */
class GraphParserTest {

    private val graphParser = GraphParser()

    @Test
    fun `blank input should throw exception`() {
        assertThrows<IllegalArgumentException>("The input cannot be blank!") {
            graphParser.parse(" ")
        }
    }

    @Test
    fun `input with unknown characters should throw exception`() {
        val input = """
            SB
            XI
        """.trimIndent()

        assertThrows<IllegalArgumentException>("Unknown character 'I' at position (1, 1)") {
            graphParser.parse(input)
        }
    }

    @Test
    fun `valid input should return correct list`() {
        val expected = Graph(
            listOf(
                Coordinate(0, 0, CoordinateType.START),
                Coordinate(1, 0, CoordinateType.OBSTACLE),
                Coordinate(0, 1, CoordinateType.END),
                Coordinate(1, 1, CoordinateType.PLAIN)
            )
        )

        val input = """
            SB
            X.
        """.trimIndent()

        assertEquals(graphParser.parse(input), expected)
    }
}