package com.example.transoholic.transoholic
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.transoholic.R
import com.example.transoholic.Word
//Recycle view adapter code.

class Adapter(private val list: List<Word>)
    : RecyclerView.Adapter<WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WordViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word: Word = list[position]
        holder.bind(word)
    }

    override fun getItemCount(): Int = list.size

}
//printing data on text views in connection with recycle view
class WordViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_word, parent, false)) {
    private var wlangView: TextView? = null
    private var wtextView: TextView? = null
    private var wtolangView: TextView? = null
    private var wtotextView: TextView? = null

    init {
        wlangView = itemView.findViewById(R.id.tv_lang)
        wtextView = itemView.findViewById(R.id.tv_text)
        wtolangView= itemView.findViewById(R.id.tv_to_lang)
        wtotextView = itemView.findViewById(R.id.tv_to_text)

    }

    fun bind(word: Word) {
        wlangView?.text = word.lang
        wtextView?.text = word.text
        wtolangView?.text = word.toLang
        wtotextView?.text = word.toText
    }

}