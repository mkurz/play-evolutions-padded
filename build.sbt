name := "Evolutions Padded"

lazy val `root` = (project in file(".")).enablePlugins(PlayMinimalJava).disablePlugins(PlayFilters)

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
    guice,
    javaJdbc,
    evolutions,
    "com.h2database" % "h2" % "1.4.196"
)

//PlayKeys.externalizeResources := false
