package com.example.danhba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UserListActivity : AppCompatActivity() {

    companion object {
        const val DETAIL_ACTIVITY_CODE = "DETAIL_ACTIVITY_CODE"
    }

    private val userList: ArrayList<User> = arrayListOf()
    private lateinit var mAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = UserAdapter(userList).apply {
            onClickItem = {
                navigateToUserDetail(it)
            }
        }

        repeat(5) {
            userList.add(
                User(
                    it,
                    "Hoang",
                    "0123456789",
                    "hoangpv@gmail.com"
                )
            )
        }
        repeat(5) {
            userList.add(
                User(
                    it,
                    "Pham",
                    "0123456789",
                    "pvhoang@gmail.com"
                )
            )
        }


        findViewById<RecyclerView>(R.id.rlvMain).apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun navigateToUserDetail(user: User) {
        val i = Intent(applicationContext, DetailActivity::class.java)
        i.putExtra(DETAIL_ACTIVITY_CODE, user)
        startActivity(i)
    }
}
