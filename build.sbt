name := "gatlings"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test"

libraryDependencies += "io.gatling" % "gatling-test-framework"  % "2.3.0" % "test"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"

fork := true

enablePlugins(GatlingPlugin)
