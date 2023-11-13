package com.miu.productapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var plist:ArrayList<Product>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.textName).text = plist[position].productName
        holder.itemView.findViewById<TextView>(R.id.textDescription).text = plist[position].productDescription
        holder.itemView.findViewById<TextView>(R.id.textPrice).text = "$"+plist[position].cost.toString()
        holder.itemView.findViewById<ImageView>(R.id.productImage).setImageResource(plist[position].image)
        holder.itemView.findViewById<ImageView>(R.id.imageIcon).setImageResource(plist[position].icon)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,DetailActivity::class.java )
            val prdName = plist[position].productName
            Toast.makeText(context, "$prdName Clicked", Toast.LENGTH_LONG).show()

            intent.putExtra("name",plist[position].productName)
            intent.putExtra("desc",plist[position].productDescription)
            intent.putExtra("price","$"+plist[position].cost.toString())
            intent.putExtra("image",plist[position].image)
            intent.putExtra("icon",plist[position].icon)
            context.startActivity(intent)
        }

        holder.itemView.findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val productName = plist[position].productName
            (context as? MainActivity)?.addToNameList(productName)
        }

    }
    override fun getItemCount(): Int {
        return plist.size
    }
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
}