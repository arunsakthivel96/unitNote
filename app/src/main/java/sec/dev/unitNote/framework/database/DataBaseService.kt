package sec.dev.unitNote.framework.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sec.dev.utility.constansproperties.DaoValueConstant
import sec.dev.utility.constansproperties.NumericConstant

@Database(entities = [NoteEntity::class],version = NumericConstant.NumberOneConstant)
abstract class DataBaseService : RoomDatabase(){
    companion object{

        private const val DATABASE_NAME=DaoValueConstant.DataBaseNameConstant

        private var instance:DataBaseService? =null

        private fun create(context: Context): DataBaseService =Room.databaseBuilder(context,DataBaseService::class.java,
            DATABASE_NAME).fallbackToDestructiveMigration().build()
        fun getInstance(context: Context):DataBaseService =(instance ?: this.create(context)).also {
            instance =it
        }
    }

    abstract fun noteDao():NoteDao
}