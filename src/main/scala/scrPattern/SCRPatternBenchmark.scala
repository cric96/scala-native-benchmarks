package scrPattern

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object SCRPatternBenchmark extends communitybench.Benchmark {

  class SCRPattern extends AggregateProgram with StandardSensors with BuildingBlocks {
    override def main(): Any = {
      val leader = S(10, nbrRange)
      val collectInfo = C[Double, ID](classicGradient(leader, nbrRange), _ + _, 1, 0)
      G[Int](leader, collectInfo, a => a, nbrRange)
    }
  }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new SCRPattern) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}