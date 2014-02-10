package com.robb1e.helloworld

import org.springframework.stereotype.Service

trait Name {
  def name: String
}

@Service
class NameService extends Name {

  def name = "world"

}
