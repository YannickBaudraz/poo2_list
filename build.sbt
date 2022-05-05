import sbtide.Keys.idePackagePrefix

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "LinkedList",
    idePackagePrefix := Some("com.cpnv")
  )
libraryDependencies += "org.scalatest" %% "scalatest-wordspec" % "3.2.11" % Test