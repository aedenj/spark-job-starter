name := "Spark Starter Job"
version := "1.0"
scalaVersion := "2.12.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.4"
Compile/packageBin/artifactPath:= baseDirectory.value / "build" / "example.jar"
