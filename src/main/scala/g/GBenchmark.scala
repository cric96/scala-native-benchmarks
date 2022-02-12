package g

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object GBenchmark extends communitybench.Benchmark {

    class GCheck extends AggregateProgram with StandardSensors with BlockG {
        override def main() = G[ID](mid() == 0, mid(), a => a, nbrRange)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new GCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
