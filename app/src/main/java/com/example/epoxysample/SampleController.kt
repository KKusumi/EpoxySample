package com.example.epoxysample

import com.airbnb.epoxy.TypedEpoxyController

class SampleController(
    private val onClickItem: (String) -> Unit
) : TypedEpoxyController<List<Person>>() { // 使用するクラスが二つとかの場合は、Typed2EpoxyControllerとかを使います。

    override fun buildModels(data: List<Person>?) {
        data ?: return
        data.forEachIndexed { i, person ->
            sampleList {
                id(this@SampleController.modelCountBuiltSoFar)
                person(person)
                onClick { _ ->
                    this@SampleController.onClickItem.invoke(person.name)
                }
            }
        }
    }
}