package com.rubengees.pathfinder

/**
 * Simple data class for holding the x and y position of a single coordinate with the type.
 *
 * @author Ruben Gees
 */
data class Coordinate(val x: Int, val y: Int, val type: CoordinateType = CoordinateType.PLAIN)

private const val DIAGONAL_COST = 1.5f

/**
 * Calculates the cost of this coordinate to the [other] coordinate.
 * Diagonal steps are counted as 1.5 while vertical or horizontal steps are counted as 1.
 * The order of the coordinates does not affect the result.
 */
infix fun Coordinate.costTo(other: Coordinate): Float {
    val xDifference = Math.abs(this.x - other.x)
    val yDifference = Math.abs(this.y - other.y)

    val smallerDifference = Math.min(xDifference, yDifference)
    val biggerDifference = Math.max(xDifference, yDifference)

    // The smallerDifference is the amount of possible diagonal steps.
    // Add the biggerDifference minus the already used smallerDifference to get the result.
    return smallerDifference * DIAGONAL_COST + (biggerDifference - smallerDifference)
}
