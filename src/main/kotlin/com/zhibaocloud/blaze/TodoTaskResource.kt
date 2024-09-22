package com.zhibaocloud.blaze

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/tasks")
class TodoTaskResource(private val svc: TodoService) {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  fun list(): List<TodoView> = svc.list()
}
