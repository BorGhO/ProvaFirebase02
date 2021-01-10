package com.example.provafirebase02

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcking.github.com.giraffeplayer2.VideoView

class Adapter (data:ArrayList<Lesson>, var context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var data:List<Lesson>

    init {

        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layout = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val videoItem = data[position]
        holder.title.text = videoItem.title
        holder.desc.text = videoItem.desc
        holder.video.setVideoPath(videoItem.videoUrl)
        holder.downLoad.setOnClickListener{

            var dLoad = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            var videoUrl = Uri.parse(videoItem.videoUrl)
            var getVideo = DownloadManager.Request(videoUrl)
            getVideo.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            dLoad.enqueue(getVideo)
        }
    }



    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){

        var title:TextView
        var desc:TextView
        var video:VideoView
        var downLoad : Button

        init{

            title = item.findViewById(R.id.videoTitle)
            desc = item.findViewById(R.id.videoDesc)
            video = item.findViewById(R.id.videoView)
            downLoad = item.findViewById(R.id.downButt)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}