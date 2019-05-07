package a2018.by.step.myquiz.model

abstract class Question<T>(
    val text: String,
    var rightAnswer: T
) {
    var userAnswer: T? = null
    abstract fun checkAnswer(): Boolean
}

class ChoiceQuestion(
    text: String,
    rightAnswer: Int,
    val answers: List<String>
) : Question<Int>(text, rightAnswer) {
    override fun checkAnswer(): Boolean {
        return userAnswer == rightAnswer
    }
}

class TextQuestion(
    text: String,
    rightAnswer: String
) : Question<String>(text, rightAnswer) {
    override fun checkAnswer(): Boolean {
        return rightAnswer.equals(userAnswer, true)
    }
}