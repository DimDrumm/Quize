package a2018.by.step.myquiz.model

import android.os.Parcel
import android.os.Parcelable
import timber.log.Timber

abstract class Question<T>(
    val text: String, var rightAnswer: T
) : Parcelable {
    var id: Int = idCounter
    var userAnswer: T? = null

    abstract fun checkAnswer(): Boolean

    companion object {
        var idCounter = 0
            get() = field++
    }
}

class ChoiceQuestion(
    text: String,
    rightAnswer: Int,
    val answers: List<String>
) : Question<Int>(text, rightAnswer) {
    constructor(parcel: Parcel) : this("", 1, listOf())


    override fun checkAnswer(): Boolean {
        return userAnswer == rightAnswer
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(answers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChoiceQuestion> {
        override fun createFromParcel(parcel: Parcel): ChoiceQuestion {
            return ChoiceQuestion(parcel)
        }

        override fun newArray(size: Int): Array<ChoiceQuestion?> {
            return arrayOfNulls(size)
        }
    }
}

class TextQuestion(
    text: String,
    rightAnswer: String
) : Question<String>(text, rightAnswer) {

    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readString()!!) {
        Timber.d("In TextQuestion constructor")
    }


    override fun checkAnswer(): Boolean {
        return rightAnswer.equals(userAnswer, true)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
        parcel.writeString(rightAnswer)
        parcel.writeInt(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "TextQuestion #$id text:$text answer:$rightAnswer"
    }

    companion object CREATOR : Parcelable.Creator<TextQuestion> {

        override fun createFromParcel(parcel: Parcel): TextQuestion {
            val q = TextQuestion(parcel)
            q.id = parcel.readInt()
            return q
        }

        override fun newArray(size: Int): Array<TextQuestion?> {
            return arrayOfNulls(size)
        }
    }
}