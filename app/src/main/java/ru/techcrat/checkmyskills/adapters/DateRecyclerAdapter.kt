package ru.techcrat.checkmyskills.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import ru.techcrat.checkmyskills.R
import ru.techcrat.checkmyskills.databinding.FragmentDateBinding
import kotlin.collections.ArrayList


class DateRecyclerAdapter(private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var dates: List<String>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return LocalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_elem,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocalViewHolder -> holder.bind(dates[position])
        }


    }

    override fun getItemCount(): Int {
        return dates.size
    }

    fun submitData(data: List<String>) {
        dates = data
        notifyDataSetChanged()
    }

    inner class LocalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val dateText = itemView.findViewById<TextView>(R.id.date_elem_tv)

        fun bind(date: String) {
            dateText.text = date
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}


