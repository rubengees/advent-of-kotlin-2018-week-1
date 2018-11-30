package com.rubengees.pathfinder

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

@Suppress("unused")
@State(Scope.Benchmark)
open class PathFinderBenchmark {

    private val input = """
..B....B..B.....BB.BBB......B..B.......B....BBB.....BB.B....BB.BB..BB.......BBB...BBBBB.....B...B..B
....BB.....B.B.B....BBB..........BBB.B....BB..B.B..B...BBBBBBBB..BB.B..........B..B.......B.BB..B..B
B.......S.B.B.....B.........B.B..B...B...BB.BB.B...B.B.B...B..BB.BB.....BB..B........BB.B..B......BB
.......B..BBBB.B.....B....B...B.B..B...B...BB.B.BBB..BBB....B......B....B..B.B.BB......BB....BB....B
......B.BB.B.B......B..BBBB.B..BBBBB..B.B.BB.BBBBBB.BB.B..B.BBB..B......B......B....B........B.B..B.
B.....B......BB..BBB..B.B....BB.BBBBB.....BB..B..B..BB..BB..BB.BB......BB....B.BB.B...B..B......B...
B.B.B.................BB.B.B....BB.....BB.BB...BB.BB..B.B.......B......BB...BB.BB...BB...BB..B...B..
BB...BB.......BBBB........BBB..BBB.B.B...B..B....B...BBB..........B..B..B..BB..BB...BB..B...BBBBB..B
....B..B....B...B.B.B...B.BB........B....BBB..........B...B.BB.B..BB..B.......BB...B.B..B...B..B....
.........B.....BB.B.....B...BB.B.B.BBBB....B.....B.......BBBBB....B.B............BB.....B........B..
.B..B.B.B...............B..B.B.....B.BB.BB.B...B.BBB....BB.......BB...B.B.BBBB......B...B.....B.....
.B..B.....B.B..BB....BB.......B.B.BBB.B.....B..BB.B...B.....B..B...B..B.B..B.BB......B..B..B.....B.B
.......B.BBB.BB.......B.BBB....B...BB...B..........B.......B...B.....BBBB.B....B..B..BB.B.B.B...B.B.
B.B..BB.........BB.......BB.....B.BB..BB..BBB..B...BB....B.BBB..B....B.B....B.BBBB..B..BB.B.........
.B..BB......B...B..BB..BBB.B.B.B.BB.B.B..BBB.BBBB.B..B......BB.....BB.....B....BB....B..BB..........
B.B..B...B.B.B..B.B..B......B.B.B.BBB.B.B.B....B........BB..B....BB....BBB.BB.B....B...B....BBB.....
.B..BB...B.....B.B.B.BBB.B.........B...B..B.B...BBBBB....B.BBB..BB...........B.....BBBB....B.....BB.
.B......BB...BB.......B..B.B....B.BBB...BB.B......B.BBB..B....BB....BB....B.........B.B.B...BB....B.
B..B...B...B......B.....B......B..B..B....B.B.B.........B.BBB.B..B..BB..B..BB..B.....B..BB.BB.B....B
B.BB...B..BB..B.BB.B........B.BB......B...B.B..BB.BB.B.B......B...B..B.B...BBB...BBB.........X..B..B
.B.B.B.....B.BB..BB...BB.....B.BB.....B...BB...BBB..B..BBB..B.B.....B......B.....BB.....B..B.B..B...
BB...B.B..BB..B.B......B.....B....BBB...BBB.B...B.....B..BBBB.B..B..BBBBBB....BB.BB.B....BB.BB.BBB..
..B....B..BB........B..BB..BB..B...B.B..BB.B....BBB..B.....B......B...........BBBB.......B.BB....B..
BB....BBB...B.B...B.....B.B..B.B....B.B.B...B.B..BBBBBB.B....B...BB..BBB...B.BB....B.........BB..B..
        """.trimIndent()

    private val pathFinder = PathFinder()

    @Benchmark
    fun addPath() {
        pathFinder.addPath(input)
    }
}
