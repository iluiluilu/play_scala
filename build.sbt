name := "play_scala"

version := "1.0"

lazy val `play_scala` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice )

resolvers += "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies += "org.reactivemongo" % "play2-reactivemongo_2.12" % "0.20.2-play28"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

