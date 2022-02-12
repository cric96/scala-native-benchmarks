package rep

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object RepBenchmark extends communitybench.Benchmark {

    class RepCheck extends AggregateProgram {
        override def main = rep(0)(_ + 1)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new RepCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}