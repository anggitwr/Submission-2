package com.anggit.githubusersubmission2

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.detail_user.*
import android.annotation.SuppressLint as SuppressLint1

class DataDetail: AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
    }

    @SuppressLint1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_user)
        setData()
        viewPagerConfig()
    }

    private fun viewPagerConfig() {
        val pagerAdapter = PagerAdapter(this, supportFragmentManager )
        view_pager.adapter = pagerAdapter
        tabs.setupWithViewPager(view_pager)

        supportActionBar?.elevation = 0f
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            this.title = title
        }
    }

    @SuppressLint1
    private fun setData(){
        val dataUser = intent.getParcelableExtra(EXTRA_DATA) as DataUser
        dataUser.name?. let { setActionBarTitle(it) }
        detail_name.text = dataUser.name
        detail_username.text = dataUser.username
        detail_company.text = getString(R.string.tv_company, dataUser.company)
        detail_location.text = getString(R.string.tv_location, dataUser.location)
        detail_repository.text = getString(R.string.tv_repository, dataUser.repository)
        detail_followers.text = getString(R.string.tv_followers, dataUser.followers)
        detail_following.text = getString(R.string.tv_following, dataUser.following)
        Glide.with(this)
            .load(dataUser.avatar)
            .into(detail_avatar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_change_setting){
            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}