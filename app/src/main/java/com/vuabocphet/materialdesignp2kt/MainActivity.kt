package com.vuabocphet.materialdesignp2kt

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener{

    var myAdapter: MyAdapter? = null
    var students: ArrayList<Student>? = null
    var layoutManager: LinearLayoutManager? = null
    private var toolbar: Toolbar? = null
    private var drawer: DrawerLayout? = null
    private var navigationView: NavigationView? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        toolbar=findViewById(R.id.toolbar) as Toolbar
        navigationView=findViewById(R.id.nav_view) as NavigationView
        drawer=findViewById(R.id.drawer_layout) as DrawerLayout

        navigationView!!.setNavigationItemSelectedListener(this)

        fab.setOnClickListener(View.OnClickListener {
            var student:Student?=null
            student= Student()
            student.name="Huy" + Random().nextInt()
            student.address="Số nhà:" + Random().nextInt()

            students?.add(student)
            myAdapter?.notifyDataSetChanged()
            lvList.smoothScrollToPosition(students?.size!! -1);


        })

        var toggle:ActionBarDrawerToggle = ActionBarDrawerToggle(this,drawer_layout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer!!.addDrawerListener(toggle);
        toggle.syncState();
            students= arrayListOf()

        for (i in 0..5){
            var student1:Student?=null
            student1= Student()
            student1.name="Huy" + Random().nextInt()
            student1.address="Số nhà:" + Random().nextInt()
            students?.add(student1)

            myAdapter= MyAdapter(students!!,this)
            var linearLayoutManager:LinearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
            lvList.setHasFixedSize(true)
            lvList.layoutManager=linearLayoutManager
            lvList.adapter=myAdapter

        }
    }

    override fun onBackPressed() {
        if (drawer!!.isDrawerOpen(GravityCompat.START)){
            drawer!!.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId==R.id.action_settings){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.nav_camera ->{
                toast("nav_camera")
            }
            R.id.nav_gallery ->{
                toast("nav_gallery")
            }
            R.id.nav_slideshow ->{
                toast("nav_slideshow")
            }
            R.id.nav_manage ->{
                toast("nav_manage")
            }
            R.id.nav_share ->{
                toast("nav_share")
            }
            R.id.nav_send ->{
                toast("nav_send")
            }

        }

        drawer!!.closeDrawer(GravityCompat.START);

                  return true
    }


    fun toast(text:String){

        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }


}


