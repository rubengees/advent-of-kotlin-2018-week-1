package com.rubengees.pathfinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * @author Ruben Gees
 */
class GraphTest {

    @Test
    fun `input without start should throw an exception`() {
        val input = listOf(Coordinate(0, 0, CoordinateType.END))

        val exception = assertThrows(IllegalArgumentException::class.java) { Graph(input) }
        assertEquals(exception.message, "No start coordinate in given list!")
    }

    @Test
    fun `input without end should throw an exception`() {
        val input = listOf(Coordinate(0, 0, CoordinateType.START))

        val exception = assertThrows(IllegalArgumentException::class.java) { Graph(input) }
        assertEquals(exception.message, "No end coordinate in given list!")
    }

    @Test
    fun `the graph should return correct start coordinate`() {
        val input = listOf(
            Coordinate(0, 0),
            Coordinate(0, 1, CoordinateType.START),
            Coordinate(0, 1, CoordinateType.END)
        )

        val graph = Graph(input)
        assertEquals(graph.start, input[1])
    }

    @Test
    fun `the graph should return correct end coordinate`() {
        val input = listOf(
            Coordinate(0, 0),
            Coordinate(0, 1, CoordinateType.START),
            Coordinate(0, 1, CoordinateType.END)
        )

        val graph = Graph(input)
        assertEquals(graph.end, input[2])
    }

    @Test
    fun `the graph should return correct neighbours, excluding the input and obstacles`() {
        val input = listOf(
            Coordinate(0, 0, CoordinateType.START),
            Coordinate(0, 1, CoordinateType.END),
            Coordinate(0, 2),
            Coordinate(1, 0, CoordinateType.OBSTACLE),
            Coordinate(1, 1),
            Coordinate(1, 2, CoordinateType.OBSTACLE)
        )

        val graph = Graph(input)
        val result = graph.neighbours(input[1]) // x: 0, y: 1

        assertEquals(3, result.size)
        assertTrue(result.contains(input[0])) // x: 0, y: 0
        assertTrue(result.contains(input[2])) // x: 0, y: 2
        assertTrue(result.contains(input[4])) // x: 1, y: 1
    }
}