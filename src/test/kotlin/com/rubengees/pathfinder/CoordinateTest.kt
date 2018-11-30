package com.rubengees.pathfinder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/**
 * @author Ruben Gees
 */
class CoordinateTest {

    @DisplayName("costs between coordinates should be calculated correctly")
    @ParameterizedTest(name = "cost between ({0}, {1}) and ({2}, {3}) should be {4}")
    @CsvSource("0, 0, 0, 0, 0", "0, 0, 1, 1, 1.5", "1, 1, 0, 0, 1.5", "0, 0, 2, 4, 5", "0, 0, 3, 4, 5.5")
    fun `costs between coordinates should be calculated correctly`(
        startX: Int,
        startY: Int,
        endX: Int,
        endY: Int,
        expectedCost: Float
    ) {
        val actualCost = Coordinate(startX, startY) costTo Coordinate(endX, endY)

        assertEquals(expectedCost, actualCost)
    }
}