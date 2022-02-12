package buildingBlocksBundle

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object BuildingBlocksBundleBenchmark extends communitybench.Benchmark {

    class BuildingBlocksBundleCheck extends AggregateProgram with StandardSensors with BuildingBlocks {
        override def main(): Any = 10
    }
    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new BuildingBlocksBundleCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
