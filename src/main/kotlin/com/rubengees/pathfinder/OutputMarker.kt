package com.rubengees.pathfinder

/**
 * Utility class for marking the output with the found path.
 *
 * @author Ruben Gees
 */
class OutputMarker {

    private companion object {
        private const val MARKER_SYMBOL = "*"
    }

    /**
     * Marks the found [path] on the given [input] with the marker symbol ('*').
     * This method does not perform any defensive checks, since it should only be called after parsing which already
     * does validate the input.
     */
    fun mark(input: String, path: List<Coordinate>): String {
        val splitInput = input.split("\n").map { StringBuilder(it) }

        path.forEach { (x, y) ->
            splitInput[y].replace(x, x + 1, MARKER_SYMBOL)
        }

        return splitInput.joinToString(separator = "\n")
    }
}
