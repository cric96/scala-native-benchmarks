package t

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object TBenchmark extends communitybench.Benchmark {

    class TCheck extends AggregateProgram with BlockT {
        override def main(): Any = T(100)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new TCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
