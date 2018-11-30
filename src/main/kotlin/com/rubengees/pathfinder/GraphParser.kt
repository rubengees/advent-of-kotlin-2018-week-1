package com.rubengees.pathfinder

/**
 * Class for parsing graphs in String form into the object based representation.
 *
 * @author Ruben Gees
 */
class GraphParser {

    /**
     * Parses the given [input] into the graph.
     * The input is split with the '\n' character.
     * Upon finding an unknown char, an exception is thrown and all further processing is aborted.
     */
    fun parse(input: String): Graph {
        if (input.isBlank()) throw IllegalArgumentException("The input cannot be blank!")

        return input.split("\n")
            .withIndex()
            .flatMap { (y, string) ->
                string.mapIndexed { x, char ->
                    val type = when (char) {
                        'S' -> CoordinateType.START
                        'X' -> CoordinateType.END
                        'B' -> CoordinateType.OBSTACLE
                        '.' -> CoordinateType.PLAIN
                        else -> throw IllegalArgumentException("Unknown character '$char' at position ($x, $y)")
                    }

                    Coordinate(x, y, type)
                }
            }
            .toGraph()
    }

    private fun List<Coordinate>.toGraph() = Graph(this)
}
