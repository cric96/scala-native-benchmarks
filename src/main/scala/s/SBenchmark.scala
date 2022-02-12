package s

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object SBenchmark extends communitybench.Benchmark {

    class SCheck extends AggregateProgram with StandardSensors with BlockS {
        override def main(): Any = S(10, nbrRange)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new SCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
