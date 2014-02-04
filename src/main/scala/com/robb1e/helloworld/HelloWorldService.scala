package com.robb1e.helloworld

import org.springframework.stereotype.Service

trait HelloWorldName {
  def name: String
}

@Service
class HelloWorldService extends HelloWorldName {

  def name = "world"

}
