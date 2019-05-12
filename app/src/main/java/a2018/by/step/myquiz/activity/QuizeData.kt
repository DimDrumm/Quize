package a2018.by.step.myquiz.activity

import a2018.by.step.myquiz.data.QuestionRepository
import a2018.by.step.myquiz.model.Question
import android.util.Log
import java.util.*


class QuizeData {
    val questions = mutableListOf<Question<*>>().apply { addAll(QuestionRepository.getQuestions()) }
    var answeredQuestionsList = mutableListOf<Data>()

    fun getRandomQuestion(): Question<*>? {
        return if (questions.isEmpty()) {
            null
        } else {
            val item = Random().nextInt(questions.size)
            val returnQuestion = questions[item]
            Log.d("QuizeData","$returnQuestion")
            answeredQuestionsList.add(Data(questions[item].checkAnswer(), questions[item]))
            questions.removeAt(item)
            returnQuestion
        }
    }

    fun getRightQuantityAnswers(): Int {
        var rightAnswerQuantity = 0
        for (item in answeredQuestionsList) {
            if (item.isRight) {
                rightAnswerQuantity++
            }
        }
        return rightAnswerQuantity
    }
}

class Data(val isRight: Boolean, val question: Question<*>)

