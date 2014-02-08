package com.robb1e.helloworld

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._
import org.springframework.web.servlet.ModelAndView
import org.springframework.beans.factory.annotation.Autowired
import collection.JavaConversions._
import org.springframework.ui.Model

@Controller
@RequestMapping(Array("/"))
class HelloWorldController @Autowired() (helloWorldService: HelloWorldName) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def index (model: Model) = {
    model.addAttribute("name", helloWorldService.name)
    "index"
  }

}
