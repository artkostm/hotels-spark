package by.artsiom.bigdata101.hotels

import java.net.URI

import com.whisk.docker.scalatest.DockerTestKit
import com.whisk.docker.{ContainerLink, DockerContainer, DockerReadyChecker}
import org.scalatest.Suite

import scala.concurrent.duration
import scala.concurrent.duration.FiniteDuration

/**
  * Deploys 3 containers: one spark master and two spark workers
  */
trait DockerSparkService extends DockerTestKit  { self: Suite =>

  // this is for cases when the docker is running on Windows using VirtualBox
  val host = new URI(sys.env("DOCKER_HOST")).getHost

  val master = DockerContainer(image = "bde2020/spark-master:2.3.2-hadoop2.7", name = Some("spark-master"))
    .withPorts(8080 -> Some(8080), 7077 -> Some(7077))
    .withEnv("INIT_DAEMON_STEP=setup_spark")
    .withReadyChecker(
      DockerReadyChecker.HttpResponseCode(port = 8080, path = "/", host = Some(host), code = 200)
        .looped(3, FiniteDuration(15, duration.SECONDS)))

  val worker1 = DockerContainer(image = "bde2020/spark-worker:2.3.2-hadoop2.7", name = Some("spark-worker1"))
    .withPorts(8081 -> Some(8081))
    .withEnv(s"SPARK_MASTER=spark://$host:7077")
    .withLinks(ContainerLink(master, "spark-master"))

  val worker2 = DockerContainer(image = "bde2020/spark-worker:2.3.2-hadoop2.7", name = Some("spark-worker2"))
    .withPorts(8082 -> Some(8082))
    .withEnv(s"SPARK_MASTER=spark://$host:7077")
    .withLinks(ContainerLink(master, "spark-master"))

  override def dockerContainers = master :: worker1 :: worker2 :: super.dockerContainers
}
