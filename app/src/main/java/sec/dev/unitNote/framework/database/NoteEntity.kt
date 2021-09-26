package sec.dev.unitNote.framework.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import sec.dev.core.data.Note
import sec.dev.utility.constansproperties.CompareConstant
import sec.dev.utility.constansproperties.DaoValueConstant

@Entity(tableName = DaoValueConstant.TableNameNoteConstant)
data class NoteEntity (
    @ColumnInfo(name = DaoValueConstant.ColNameTitleConstant)
    var title:String,
    @ColumnInfo(name = DaoValueConstant.ColNameContentConstant)
    var content:String,
    @ColumnInfo(name = DaoValueConstant.ColNameCreatedDateTimeConstant)
    var creationTime: Long,
    @ColumnInfo(name = DaoValueConstant.ColNameUpdatedDateTimeConstant)
    var updateTime:Long,
    @ColumnInfo(name = DaoValueConstant.ColNameNoteIdConstant)
    @PrimaryKey(autoGenerate = CompareConstant.TrueConstant)
    var id: Long = 0L
){
    companion object{
        fun fromNote(note:Note) = NoteEntity(note.title,note.content,note.creationTime,note.updateTime)
    }
    fun toNote() = Note(title,content,creationTime,updateTime,id)
}