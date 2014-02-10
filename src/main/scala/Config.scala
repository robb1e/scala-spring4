
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.SpringBootServletInitializer

import org.springframework.context.annotation.{ ComponentScan, Configuration }

object Config {

  def main(args: Array[String]): Unit = {
    SpringApplication.run(classOf[Config])
  }

}

@EnableAutoConfiguration
@Configuration
@ComponentScan
class Config extends SpringBootServletInitializer {

  override def configure(application: SpringApplicationBuilder): SpringApplicationBuilder = {
    application.sources(classOf[Config])
  }

}
