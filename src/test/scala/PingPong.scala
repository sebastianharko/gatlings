import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration._
import scala.language.postfixOps


class Ping extends Simulation {

  val host = sys.env.getOrElse("APP_IP_PORT", "localhost:8080")
  val users = sys.env.get("USERS").map(_.toInt).getOrElse(50)
  val time = sys.env.get("PERIOD").map(_.toInt).getOrElse(10)

  val scn1: ScenarioBuilder = scenario("Ping")
      .exec(http("ping").get(s"http://$host/ping").check(substring("pong")))

  val httpConf: HttpProtocolBuilder = http

  setUp(scn1.inject(constantUsersPerSec(users) during (time minutes))).protocols(httpConf)

}

