name := "scala-js-benchmarks"
scalaVersion := "2.12.14"
enablePlugins(ScalaJSPlugin)
// build.sbt
ThisBuild / resolvers +=
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
val scafi_version = "0.3.3+334-8d4e68d5-SNAPSHOT"

val scafi_core  = "it.unibo.scafi" %%% "scafi-core"  % scafi_version
val scafi_simulator  = "it.unibo.scafi" %%% "scafi-simulator"  % scafi_version
val scafi_commons  = "it.unibo.scafi" %%% "scafi-commons"  % scafi_version
libraryDependencies ++= Seq(scafi_core, scafi_simulator, scafi_commons)