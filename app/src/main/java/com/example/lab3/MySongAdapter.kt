package com.example.lab3

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.song_ticket.view.*


class MySongAdapter(var context: Context,var myListSong: ArrayList<SongInfo>) : BaseAdapter()
{
    override fun getView(postion: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val myView= inflater.inflate(R.layout.song_ticket, p2, false)
        val Song= this.myListSong[postion]
        myView.tvSongName.text = Song.Title
        myView.tvAuthor.text = Song.AuthorName
        myView.buPlay.setOnClickListener{
            val intent = Intent(context, AudioActivity::class.java)
            //startActivity(intent)
//            //TODO: play song
//            if(myView.buPlay.text == "Stop"){
//                mp!!.stop()
//                myView.buPlay.text = "Start"
//            }else {
//
//                try {
//                    mp!!.setDataSource(Song.SongURL)
//                    mp!!.prepare()
//                    mp!!.start()
//                    myView.buPlay.text = "Stop"
//                    //sbProgress.max=mp!!.duration
//                } catch (ex: Exception) {
//                }
//            }
        }

        return  myView

    }

    override fun getItem(item: Int): Any {
        return this.myListSong[item]
    }

    override fun getItemId(p0: Int): Long {
        return  p0.toLong()
    }

    override fun getCount(): Int {
        return this.myListSong.size
    }


}
