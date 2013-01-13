import sbt._
import Keys._

import info.sumito3478.aprikot.sbt._

object AprikotControlBuild extends Build {

  lazy val project = Project(
    id = "aprikot-control",
    base = file(".")
  ).settings(StandardProject.newSettings :_*
  ).settings(
    Seq(
      version := "0.0.6-SNAPSHOT"
    ): _*
  )

}

