package com.rubengees.pathfinder

import java.util.PriorityQueue

/**
 * Entry point for path calculation.
 * The A* algorithm is used to find an optimal way between a [CoordinateType.START] coordinate and an
 * [CoordinateType.END] coordinate on the given input.
 *
 * @author Ruben Gees
 */
class PathFinder(
    private val parser: GraphParser = GraphParser(),
    private val outputMarker: OutputMarker = OutputMarker()
) {

    /**
     * Parses the [input], finds the shortest (lowest cost) path between [CoordinateType.START] and [CoordinateType.END]
     * and returns the marked version of the input.
     * If no path is found, an exception will be thrown.
     */
    fun addPath(input: String): String {
        val graph = parser.parse(input)
        val path = findPath(graph)

        return outputMarker.mark(input, path)
    }

    private fun findPath(graph: Graph): List<Coordinate> {
        val queue = PriorityQueue<PrioritizedCoordinate>(compareBy { it.priority }).apply {
            offer(graph.start.prioritize(0f))
        }

        val costMap = mutableMapOf<Coordinate, Float>()
        val pathMap = mutableMapOf<Coordinate, Coordinate>()

        while (queue.isNotEmpty()) {
            val (current) = queue.poll()

            if (current == graph.end) {
                return reconstructPath(pathMap, graph.start, graph.end)
            }

            graph.neighbours(current).forEach { next ->
                val newCost = (costMap[current] ?: 0f) + (current costTo next)

                if (costMap.contains(next).not() || newCost < costMap.getValue(next)) {
                    costMap[next] = newCost

                    queue += next.prioritize(newCost + (next costTo graph.end))
                    pathMap[next] = current
                }
            }
        }

        throw IllegalArgumentException("No path found!")
    }

    private fun reconstructPath(
        pathMap: Map<Coordinate, Coordinate>,
        start: Coordinate,
        end: Coordinate
    ): List<Coordinate> {
        val result = mutableListOf<Coordinate>()
        var current = end

        while (current != start) {
            result += current
            current = pathMap[current]
                ?: throw IllegalStateException("Could not reconstruct path: No previous corrdinate for $current")
        }

        return result.plus(start)
    }

    private data class PrioritizedCoordinate(val coordinate: Coordinate, val priority: Float)

    private fun Coordinate.prioritize(priority: Float) = PrioritizedCoordinate(this, priority)
}
