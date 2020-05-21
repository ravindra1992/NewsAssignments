package com.example.newsassignment


import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.newsassignment.db.entity.NewsDao
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.example.newsassignment.db.cache.DbCache
import com.example.newsassignment.utils.Constants.db_name

@RunWith(JUnit4::class)
class DBInstance {

companion object{

    var databseInstance:NewsDao?=null

    fun getInstance():NewsDao{
        if(databseInstance ==null){

            databseInstance =Room.databaseBuilder(
                    ApplicationProvider.getApplicationContext(),
                    DbCache::class.java,
                    db_name
                ).fallbackToDestructiveMigration()
                .build().newsDao()
        }

        return databseInstance as NewsDao

    }

}
}
