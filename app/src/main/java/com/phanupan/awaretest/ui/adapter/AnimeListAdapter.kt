package com.phanupan.awaretest.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.phanupan.awaretest.R
import com.phanupan.awaretest.model.Top
import com.phanupan.awaretest.ui.AnimeDetailActivity
import com.squareup.picasso.Picasso

class AnimeListAdapter constructor(
    private val mContext: Context,
    private val animeLs: MutableList<Top>
) : RecyclerView.Adapter<AnimeListAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageTitle: ImageView = view.findViewById(R.id.image_title)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.single_item_anime, parent, false)
        return AnimeListAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeLs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = animeLs.get(position)

        holder.tvTitle.text = anime.title
        Picasso.get().load(anime.imageUrl).into(holder.imageTitle)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext, AnimeDetailActivity::class.java)
            intent.putExtra("anime_id", anime.malId.toString())
            mContext.startActivity(intent)
        })

    }
}