package com.vuabocphet.materialdesignp2kt

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MyAdapter(var students:ArrayList<Student>,var context:Context): RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var layout: LayoutInflater = LayoutInflater.from(parent.context)
        var view: View =layout.inflate(R.layout.item,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        if (students == null) return 0

        else

            return students.size

    }


    override fun onBindViewHolder(holder: MyHolder, i: Int) {
        holder.tvName.setText(students.get(i).name)
        holder.tvAddress.setText(students.get(i).address)
        holder.tvAddress.setOnClickListener(View.OnClickListener {

          var student:Student=students.get(i)

            student.name = "ABC";
            student.address = "CBA";

            notifyDataSetChanged()

        })

        holder.tvName.setOnClickListener(View.OnClickListener {

            students.removeAt(i)

            notifyItemRemoved(i);
        })

    }
}