# Advent of Kotlin 2018 Week 1

Solution for Week 1 of [Advent of Kotlin](https://blog.kotlin-academy.com/the-advent-of-kotlin-2018-week-1-229e442a143?gi=a21d1b2afa8e).

It is based on the [A* algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm), which finds one of the optimal paths with good performance by using an additional heuristic.
The A* algorithm is otherwise similar to the widely-known [Dijkstra algorithm](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm).

Two of the [original tests](https://gist.github.com/MarcinMoskala/2f586da50a93f7954beff616e9207fa8) have been adjusted to a different, but still perfect path in terms of cost (see comments in the tests).

### Project Structure

This is a normal [Gradle](https://gradle.org/) project.
The code can be found in the `src/main` folder; The tests are in `src/test`.
The project can be built with:

```
./gradlew build
```

This compiles the code and runs all tests and static code checks.

### Benchmark

These are the results of an [JMH](https://openjdk.java.net/projects/code-tools/jmh/) benchmark (`navigate on forest` test) on a Linux `4.19.2` device with an<br>
`Intel® Core™ i7-7700T CPU @ 2.90GHz × 8`:

| Benchmark                   | Mode  | Cnt | Score    | Error   | Units |
| --------------------------- | ----- | --- | -------- | ------- | ----- |
| PathFinderBenchmark.addPath | thrpt | 25  | 1373,390 | ± 5,883 | ops/s |

To reproduce, run:

```
./gradlew jmh
```
