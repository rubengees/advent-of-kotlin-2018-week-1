package com.rubengees.pathfinder

/**
 * Graph for representing the world to navigate in.
 * Internally, it holds a map of all valid coordinates with the (x, y) pair as key.
 *
 * @author Ruben Gees
 */
class Graph(coordinates: List<Coordinate>) {

    val start = coordinates.find { it.type == CoordinateType.START }
        ?: throw IllegalArgumentException("No start coordinate in given list!")

    val end = coordinates.find { it.type == CoordinateType.END }
        ?: throw IllegalArgumentException("No end coordinate in given list!")

    private val coordinateMap = coordinates
        .filterNot { it.type == CoordinateType.OBSTACLE }
        .associateBy { (x, y) -> x to y }

    /**
     * Returns all valid horizontal, vertical and diagonal direct members of the given [coordinate],
     * excluding [CoordinateType.OBSTACLE]s and off-the-graph positions.
     */
    fun neighbours(coordinate: Coordinate): List<Coordinate> {
        val (x, y) = coordinate

        val result = (x - 1..x + 1).flatMap { currentX ->
            (y - 1..y + 1).map { currentY ->
                coordinateMap[currentX to currentY]
            }
        }

        return result
            .filterNotNull()
            .filterNot { it.x == x && it.y == y }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Graph

        if (coordinateMap != other.coordinateMap) return false

        return true
    }

    override fun hashCode(): Int {
        return coordinateMap.hashCode()
    }
}
