package com.e.tmdblist.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.e.tmdblist.R
import com.e.tmdblist.model.Movie
import com.e.tmdblist.view.ui.DetailMovie
import de.hdodenhof.circleimageview.CircleImageView

class MovieListAdapter(var context: Context, var movieList: List<Movie>) :
    RecyclerView.Adapter<MovieListAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.model, null, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    inner class MyViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(movie: Movie){
            val movieImg = itemView.findViewById<CircleImageView>(R.id.films_img_civ)
            val movieName = itemView.findViewById<TextView>(R.id.films_name_tv)
            val moviePopularity = itemView.findViewById<TextView>(R.id.films_popularity_tv)

            movieName.text = movie.original_title
            moviePopularity.text = movie.popularity.toString()

            Glide.with(context)
                .load(movie.getPosterPath())
                .into(movieImg)

            view.setOnClickListener{
                val intent = Intent(view.context, DetailMovie::class.java)
                intent.putExtra("movie_id", movie.id)
                view.context.startActivity(intent)
            }
        }
    }

}