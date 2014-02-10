package com.robb1e.helloworld

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.webapp.WebAppContext
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext

object ApplicationServer {
  def main(args: Array[String]) {

    val server = new Server(8080)
    val context = new WebAppContext()
    val servlet = new DispatcherServlet()
    val servletHolder = new ServletHolder(servlet)

    servlet.setContextClass(classOf[AnnotationConfigWebApplicationContext])
    servlet.setContextConfigLocation("com.robb1e.helloworld.Config")

    context setContextPath "/"
    context setResourceBase "src/main/webapp"
    context addServlet(servletHolder, "/")

    server.setHandler(context)
    server.start
    server.join
  }
}

