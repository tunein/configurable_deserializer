import org.typelevel.scalacoptions.ScalacOptions
import sbtassembly.AssemblyPlugin.autoImport.*


name                                     := "configurable_deserializer"
version                                  := sys.env.getOrElse("CREATED_TAG", "0.6")
scalaVersion                             := "2.13.16"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.4.0"
libraryDependencies ++= Seq(
  "com.thesamet.scalapb"               %% "scalapb-runtime"                         % scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.11" % "2.9.6-0"                               % "protobuf",
  "com.thesamet.scalapb.common-protos" %% "proto-google-common-protos-scalapb_0.11" % "2.9.6-0",
  "com.fasterxml.jackson.core"         % "jackson-databind"       % "2.14.3",
  "org.scala-lang"                     %% "toolkit-test"          % "0.7.0"         % Test

)

Compile / tpolecatExcludeOptions ++= Set(
  ScalacOptions.warnNonUnitStatement, // for scalaPB gen sources
)

assembly / assemblyJarName := "configurable_deserializer.jar"

// ## Github Packages publish configs
// More info, see: https://gist.github.com/guizmaii/2ca47b74ad8e26c772d7df6ada8ddb00
val GITHUB_OWNER   = "tunein"
val GITHUB_PROJECT = "configurable_deserializer"

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"
)

ThisBuild / publishTo         := Some(
  s"GitHub $GITHUB_OWNER Apache Maven Packages" at s"https://maven.pkg.github.com/$GITHUB_OWNER/$GITHUB_PROJECT"
)
ThisBuild / publishMavenStyle := true
ThisBuild / credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  GITHUB_OWNER,
  System.getenv("GITHUB_TOKEN")
)

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "versions", "9", "module-info.class") => MergeStrategy.first
  case PathList("com", "google", "type", xs @ _*) => MergeStrategy.first
  case x => (assembly / assemblyMergeStrategy).value(x)
}
