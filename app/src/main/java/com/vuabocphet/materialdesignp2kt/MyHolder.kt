package com.vuabocphet.materialdesignp2kt

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MyHolder(itemViews:View?): RecyclerView.ViewHolder(itemViews) {

    var tvName: TextView = itemView!!.findViewById(R.id.tvName)
    var tvAddress: TextView = itemView!!.findViewById(R.id.tvAddress)


}
