import sbt._

object Dependencies {

  object Versions {
    val ScalaVersion = "2.12.9"
    val JDKVersion = "1.8"
    val AkkaVersion = "2.5.26"
    val AkkaHttpVersion = "10.1.9"
    val PlayJsonVersion = "2.7.4"
    val AkkaHttpPlayJsonVersion = "1.27.0"
    val H2DatabaseVersion = "1.4.196"
    val SlickVersion = "3.2.0"
    val SLF4JNopVersion = "1.6.4"
  }

  import Versions._

  object Main {

    val AkkaActor = "com.typesafe.akka" %% "akka-actor" % AkkaVersion
    val AkkaHttp = "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
    val AkkaStream = "com.typesafe.akka" %% "akka-stream" % AkkaVersion
    val PlayJson = "com.typesafe.play" %% "play-json" % PlayJsonVersion
    val AkkaHttpPlayJson = "de.heikoseeberger" %% "akka-http-play-json" % AkkaHttpPlayJsonVersion
    val H2Database = "com.h2database" % "h2" % H2DatabaseVersion
   val Slick = "com.typesafe.slick" %% "slick" % SlickVersion
    val SLF4JNop = "org.slf4j" % "slf4j-nop" % SLF4JNopVersion

    val All: Seq[ModuleID] = Seq(
      AkkaActor,
      AkkaHttp,
      AkkaStream,
      PlayJson,
      AkkaHttpPlayJson,
      H2Database,
      Slick,
      SLF4JNop
    )
  }
}
