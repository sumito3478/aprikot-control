import sbt._
import Keys._

object AprikotControlBuild extends Build {

  lazy val project = Project(
    id = "aprikot-control",
    base = file(".")
  ).settings(
    Seq(
      version := "0.0.2",
      scalaVersion := "2.10.0",
      scalacOptions ++= Seq(
        "-target:jvm-1.6",
        "-deprecation",
        "-feature",
        "-explaintypes",
        "-unchecked"
        ),
      publishMavenStyle := true,
      publishTo := Some(Resolver.sftp(
        "sumito3478 Maven Repository (push)",
        "maven.sumito3478.info",
        46877,
        "/var/www/maven.sumito3478.info") as (
        "sumito3478",
        new java.io.File(
          new java.io.File(System.getProperty("user.home")),
          ".ssh/sumito3478-sshkey"))),
      resolvers := Seq(
        "sumito3478 Maven Repository (pull)" at "http://maven.sumito3478.info/",
        "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots",
        "Maven Repository Mirror" at "http://uk.maven.org/maven2"),
      externalResolvers <<= resolvers map {
        rs =>
          Resolver.withDefaultResolvers(rs, mavenCentral = false)
      },
      libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "2.0.+" % "test"
      )
    ): _*
  )

}

