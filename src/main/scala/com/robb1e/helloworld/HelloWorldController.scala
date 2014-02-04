package com.robb1e.helloworld

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView
import org.springframework.beans.factory.annotation.Autowired
import collection.JavaConversions._

@Controller
@RequestMapping(Array("/"))
class HelloWorldController @Autowired() (helloWorldService: HelloWorldName) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def index = {
    val params = Map("name" -> helloWorldService.name)
    new ModelAndView("index", params)
  }

}
