package com.zhibaocloud.blaze

import com.blazebit.persistence.CriteriaBuilderFactory
import com.blazebit.persistence.view.EntityView
import com.blazebit.persistence.view.EntityViewManager
import com.blazebit.persistence.view.EntityViewSetting
import com.blazebit.persistence.view.Mapping
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional

@EntityView(TodoTask::class)
interface TodoView {

  @get:Mapping("title")
  val title: String

  @get:Mapping("nullif(TodoTaskStatistic[id = VIEW(id)].amount, 0)")
  val amount: Long
}

@ApplicationScoped
class TodoService {

  @Inject
  lateinit var em: EntityManager

  @Inject
  lateinit var cbf: CriteriaBuilderFactory

  @Inject
  lateinit var evm: EntityViewManager

  @Transactional
  fun list(): List<TodoView> {
    val cb = cbf.create(em, TodoTask::class.java)
    return evm.applySetting(EntityViewSetting.create(TodoView::class.java), cb).resultList
  }
}
