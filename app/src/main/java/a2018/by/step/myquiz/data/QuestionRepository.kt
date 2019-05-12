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
                "performs the actions",
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
                "5+5",
                "10 days"
            )
        )
        questionList.add(
            ChoiceQuestion(
                "is it 2",
                2,
                "yes",
                listOf(
                    "no",
                    "yes",
                    "why"
                )
            )
        )
        questionList.add(
            ChoiceQuestion(
                "is it 2",
                3,
                "yes",
                listOf(
                    "no",
                    "why",
                    "yes"
                )
            )
        )
        questionList.add(
            ChoiceQuestion(
                "What is an activity in Android?",
                1,
                "performs the actions",
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
                "10 days",
                "5+5"
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days",
                "5+5"
            )
        )
        questionList.add(
            TextQuestion(
                "How much time Dzima didn't sleep",
                "10 days",
                "5+5"
            )
        )

        return questionList
    }
}