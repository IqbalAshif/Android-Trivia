package com.example.transoholic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.transoholic.transoholic.Adapter
import kotlinx.android.synthetic.main.word_fragment.*
//data class for words
data class Word(val lang: String, val text: String, val toLang:String, val toText:String)
class WordFragment :Fragment(){
    private val wordlist = listOf(
        Word("English", "Red", "Finnish", "Punainen"),
        Word("English", "Blue", "Finnish", "Sininen"),
        Word("English", "Green", "Finnish", "Vihrea"),
        Word("English", "White", "Finnish", "Valkoinen"),
        Word("English", "Black", "Finnish", "Musta"),
        Word("English", "Grey", "Finnish", "Harmaa"),
        Word("English", "Yellow", "Finnish", "Keltainen"),
        Word("English", "Pink", "Finnish", "Pinkki")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.word_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = Adapter(wordlist)
        }
    }

    companion object {
        fun newInstance(): WordFragment = WordFragment()
    }
}