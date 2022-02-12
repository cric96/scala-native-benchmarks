package staticField

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings



object StaticFieldBenchmark extends communitybench.Benchmark {

    // Basic constructor checks
    class StaticFieldCheck extends AggregateProgram {
        override def main = 10
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new StaticFieldCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}