package com.robb1e.helloworld

import scala.collection.JavaConversions._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HelloWorldController @Autowired() (nameService: Name) {

  @RequestMapping(Array("/"))
  def index(model: java.util.Map[String, Any]): String = {
    model += ("name" -> nameService.name)
    "index"
  }

}
