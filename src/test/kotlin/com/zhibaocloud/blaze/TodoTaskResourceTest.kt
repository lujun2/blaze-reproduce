package com.zhibaocloud.blaze

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

@QuarkusTest
class TodoTaskResourceTest {

  @Test
  fun `list todo task with enriched statistics`() {
    given()
      .`when`().get("/tasks")
      .then()
      .statusCode(200)
      .body("size()", equalTo(2))
  }
}
