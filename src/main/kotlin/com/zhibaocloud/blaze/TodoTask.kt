package com.zhibaocloud.blaze

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "todo_tasks")
class TodoTask : PanacheEntity() {

  @Column(name = "title", unique = true)
  lateinit var title: String

  @Column(name = "description")
  var description: String? = null
}

@Entity
@Table(name = "todo_task_statistics")
class TodoTaskStatistic : PanacheEntity() {

  @Column(name = "amount")
  val amount: Long = 0
}
