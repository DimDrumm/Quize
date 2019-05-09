package a2018.by.step.myquiz.fragment

import a2018.by.step.myquiz.model.Question

interface OnFragmentListener {
    fun changeFragment()
    fun getQuestionType(type:Question<*>)
}