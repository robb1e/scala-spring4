import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

assemblySettings


jarName in assembly := "hello.jar"

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case "META-INF/MANIFEST.MF" => MergeStrategy.discard
    case "META-INF/services/javax.servlet.ServletContainerInitializer" => MergeStrategy.first
    case "plugin.properties" => MergeStrategy.first
    case f if f.startsWith("META-INF/spring") => MergeStrategy.first
    case f if f.endsWith(".html") => MergeStrategy.discard
    case f if f.endsWith(".SF") => MergeStrategy.discard
    case f if f.endsWith(".DSA") => MergeStrategy.discard
    case f if f.endsWith(".RSA") => MergeStrategy.discard
    case f if f.endsWith(".inf") => MergeStrategy.discard
    case _ => MergeStrategy.deduplicate
  }
}

