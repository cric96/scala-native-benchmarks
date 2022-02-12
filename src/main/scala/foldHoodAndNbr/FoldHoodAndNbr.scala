package foldHoodAndNbr

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object FoldHoodAndNbrBenchmark extends communitybench.Benchmark {

    class FoldHoodAndNbrCheck extends AggregateProgram {
        override def main() = foldhood(Set(mid()))(_ ++ _)(Set(nbr(mid())))
    }

    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new FoldHoodAndNbrCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
