package channel

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object ChannelBenchmark extends communitybench.Benchmark {

    class ChannelCheck extends AggregateProgram with BlockG with StandardSensors {
        override def main(): Any = channel(mid() == 0, mid() == 10, 1)
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new ChannelCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
