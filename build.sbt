name := "java-benchmarks"
scalaVersion := "2.12.14"
// build.sbt
val scafi_version = "0.3.3"

val scafi_core  = "it.unibo.scafi" %% "scafi-core"  % scafi_version
val scafi_simulator  = "it.unibo.scafi" %% "scafi-simulator"  % scafi_version
val scafi_commons  = "it.unibo.scafi" %% "scafi-commons"  % scafi_version
libraryDependencies ++= Seq(scafi_core, scafi_simulator, scafi_commons)