package com.example.epoxysample

import com.airbnb.epoxy.EpoxyDataBindingPattern

// Epoxyの設定ファイルです。
// 頭に"item"とつくレイアウトをEpoxyのモデルと判定して、クラスを自動生成してくれるようになります。.
@EpoxyDataBindingPattern(rClass = R::class, layoutPrefix = "item")
object SampleEpoxyDataBindingPattern