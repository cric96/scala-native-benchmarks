package manyProcess

import it.unibo.scafi.incarnations.BasicSimulationIncarnation._
import it.unibo.scafi.config.GridSettings

object ManyProcessBenchmark extends communitybench.Benchmark {

    class ManyProcessCheck extends AggregateProgram
    with FieldUtils
    with CustomSpawn
    with BlockG
    with TimeUtils
    with StateManagement
    with StandardSensors {
        override def main(): Any = sspawn2[ID, Unit, Double](id => _ => POut(classicGradient(id == mid()), SpawnInterface.Output), Set(mid()), ())
    }
    def run(input: String): Unit = {
        val howMany = 5
        val range = 2
        val ticks = 10000
        val simulator = simulatorFactory.gridLike(GridSettings(howMany, howMany, range, range),range)
        (0 to ticks) foreach { _ => simulator.exec(new ManyProcessCheck) }
    }

    override def main(args: Array[String]): Unit = super.main(args)
}
