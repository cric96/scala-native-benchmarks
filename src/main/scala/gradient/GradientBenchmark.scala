package gradient

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object GradientBenchmark extends communitybench.Benchmark {

    class GradientCheck extends AggregateProgram with StandardSensors with BlockG with Gradients {
        override def main() = classicGradient(mid() == 0, nbrRange)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new GradientCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
