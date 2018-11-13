package by.artsiom.bigdata101.hotels

import com.whisk.docker.impl.spotify.DockerKitSpotify
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.time.{Second, Seconds, Span}

class PingPongSpec extends FlatSpec with Matchers with DockerKitSpotify with DockerSparkService {
  implicit val pc = PatienceConfig(Span(20, Seconds), Span(1, Second))

  "all containers" should "be ready at the same time" in {
    dockerContainers.map(_.image).foreach(println)
    dockerContainers.forall(c => isContainerReady(c).futureValue) shouldBe true
  }
}
