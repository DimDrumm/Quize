package a2018.by.step.myquiz.data

import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.Question
import a2018.by.step.myquiz.model.TextQuestion

object QuestionRepository {
    fun getQuestions(): List<Question<*>> {
        val questionList = mutableListOf<Question<*>>()
        questionList.add(
            ChoiceQuestion(
                "How much is the fish?",
                1,
                listOf("10", "20", "30")
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days"
            )

        )
        return questionList
    }
}