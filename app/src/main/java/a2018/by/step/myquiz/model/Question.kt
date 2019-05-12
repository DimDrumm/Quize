package a2018.by.step.myquiz.model

abstract class Question<out T>(
    val text: String,
    val rightAnswer: T,
    val prompt: String
) {
    var userAnswer: String? = null
    abstract fun checkAnswer(): Boolean
}

class ChoiceQuestion(
    text: String,
    rightAnswer: Int,
    prompt: String,
    val answers: List<String>
) : Question<Int>(text, rightAnswer, prompt) {
    override fun checkAnswer(): Boolean {
        return userAnswer.equals(rightAnswer.toString())
    }

}

class TextQuestion(
    text: String,
    rightAnswer: String,
    prompt: String
) : Question<String>(text, rightAnswer, prompt) {
    override fun checkAnswer(): Boolean {
        return rightAnswer.equals(userAnswer, true)
    }

}