package c

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object CBenchmark extends communitybench.Benchmark {

    class CCheck extends AggregateProgram with StandardSensors with BlockC with BlockG {
        override def main() = C[Double, ID](hopDistance(mid() == 0), math.max, mid(), -1)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new CCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
