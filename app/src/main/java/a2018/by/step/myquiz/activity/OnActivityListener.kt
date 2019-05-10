package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.model.Question


interface OnActivityListener {
    fun getQuestionTypeFromActivity(q:Question<*>)
    fun results(result: Int)
}