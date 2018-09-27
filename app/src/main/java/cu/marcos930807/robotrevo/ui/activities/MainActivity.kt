package cu.marcos930807.robotrevo.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.blankj.utilcode.util.Utils
import cu.marcos930807.robotrevo.ui.utils.replaceFragment


import cu.marcos930807.robotrevo.R
import cu.marcos930807.robotrevo.db.sql.NoticeDBHelper

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import org.jetbrains.anko.act

import io.multimoon.colorful.CAppCompatActivity

import org.jetbrains.anko.toast


class MainActivity : CAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.init(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        replaceFragment(R.id.content_frame, NoticeListV2.newInstance())
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(act, SettingsActivity::class.java))
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }

    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_noticelist -> {
                replaceFragment(R.id.content_frame, NoticeListFragment.newInstance())
                //ading this comment to test push from ssh

            }
            R.id.nav_gallery -> {
                replaceFragment(R.id.content_frame, NoticeListV2.newInstance())
            }
            R.id.nav_slideshow -> {
                replaceFragment(R.id.content_frame, ClientFragment.newInstance())

            }
            R.id.nav_manage -> {
                replaceFragment(R.id.content_frame, ExpandableClientFragment.newInstance())
            }
//            R.id.nav_share -> {.00.


















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































//                val paths = Environment.getExternalStorageDirectory().absolutePath
//            //    val sqliteToExcel = SQLiteToExcel(this, NoticeDBHelper.DATABASE_NAME, paths)
//            //    createBackup(sqliteToExcel)
//
//            }
//            R.id.nav_send -> {
//
//            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

//    private fun createBackup(sqliteToExcel: SQLiteToExcel) {
//
//        sqliteToExcel.exportAllTables("NoticeBackup.xls", object : SQLiteToExcel.ExportListener {
//            override fun onStart() {
//
//            }
//
//            override fun onCompleted(filePath: String) {
//             toast("Creado en ${filePath}")
//            }
//
//            override fun onError(e: Exception) {
//
//            }
//        })
//    }
}
