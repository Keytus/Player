package com.example.lab3

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView


class AudioFragment : Fragment() {

    var adapter:MySongAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_audio, null)

        val myListSong: ArrayList<SongInfo> = ArrayList<SongInfo>()

        myListSong?.add(SongInfo("Cyka","Blyat","Nax"))

        adapter = myListSong?.let { getActivity()?.let { it1 -> MySongAdapter(it1.baseContext, it) } }

        val lsListSongs: ListView? = v.findViewById(R.id.lsListSongs)

        lsListSongs?.setAdapter(adapter as ListAdapter?)

        return v
    }

}