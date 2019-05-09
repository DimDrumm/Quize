package a2018.by.step.myquiz.data

import a2018.by.step.myquiz.model.ChoiceQuestion
import a2018.by.step.myquiz.model.Question
import a2018.by.step.myquiz.model.TextQuestion

object QuestionRepository {
    fun getQuestions(): List<Question<*>> {
        val questionList = mutableListOf<Question<*>>()
        questionList.add(
            ChoiceQuestion(
                "What is an activity in Android?",
                1,
                listOf(
                    "Activity performs the actions on the screen",
                    "Manage the Application content",
                    "Screen UI"
                )
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days"
            )
        )
        questionList.add(
            ChoiceQuestion(
                "What is an activity in Android?",
                1,
                listOf(
                    "Activity performs the actions on the screen",
                    "Manage the Application content",
                    "Screen UI"
                )
            )
        )
        questionList.add(
            ChoiceQuestion(
                "What is an activity in Android?",
                1,
                listOf(
                    "Activity performs the actions on the screen",
                    "Manage the Application content",
                    "Screen UI"
                )
            )
        )
        questionList.add(
            ChoiceQuestion(
                "What is an activity in Android?",
                1,
                listOf(
                    "Activity performs the actions on the screen",
                    "Manage the Application content",
                    "Screen UI"
                )
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days"
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days"
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