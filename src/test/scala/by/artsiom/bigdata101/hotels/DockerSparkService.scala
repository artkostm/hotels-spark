package by.artsiom.bigdata101.hotels

import com.whisk.docker.scalatest.DockerTestKit
import com.whisk.docker.{DockerContainer, DockerKit, DockerReadyChecker}
import org.scalatest.Suite

trait DockerSparkService extends DockerTestKit  { self: Suite =>

  val pingContainer = DockerContainer("nginx:1.7.11")

  val pongContainer = DockerContainer("nginx:1.7.11")
    .withPorts(80 -> None)
    .withReadyChecker(
      DockerReadyChecker.HttpResponseCode(port = 80, path = "/", host = None, code = 200))

  override def dockerContainers = pingContainer :: pongContainer :: super.dockerContainers
}
