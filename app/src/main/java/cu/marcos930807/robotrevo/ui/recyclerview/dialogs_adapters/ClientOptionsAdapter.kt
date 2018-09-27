package cu.marcos930807.robotrevo.ui.recyclerview.dialogs_adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cu.marcos930807.robotrevo.R
import cu.marcos930807.robotrevo.ui.recyclerview.optionClient
import cu.marcos930807.robotrevo.ui.recyclerview.optionNotice
import kotlinx.android.synthetic.main.item_options.view.*
import org.jetbrains.anko.backgroundResource


class ClientOptionsAdapter(val options: ArrayList<optionClient>, val itemClick: (optionClient) -> Unit): RecyclerView.Adapter<ClientOptionsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_options, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindOptions(options[position])
    }




    class ViewHolder(view: View, private val itemClick: (optionClient) -> Unit) : RecyclerView.ViewHolder(view) {


        fun bindOptions(option: optionClient){

            with(option){
                itemView.setOnClickListener { itemClick(this) }
                itemView.title.text = option.title
                itemView.description.text = option.descrip
                itemView.icon.backgroundResource = option.ico!!

            }

         }

        fun getOnclickListner(): (optionClient)->Unit{
            return itemClick
        }
    }



}