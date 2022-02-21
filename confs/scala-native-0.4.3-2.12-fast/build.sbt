name := "scala-native-benchmarks"
scalaVersion := "2.12.13"
enablePlugins(ScalaNativePlugin)
import scala.scalanative.build
nativeConfig ~= {
  _.withGC(build.GC.immix)
    .withMode(build.Mode.releaseFast)
    .withLTO(build.LTO.thin)
}
libraryDependencies += "io.github.cquiroz" %%% "scala-java-time" % "2.4.0-M1"
