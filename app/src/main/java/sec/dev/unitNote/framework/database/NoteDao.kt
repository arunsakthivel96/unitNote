package sec.dev.unitNote.framework.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert(onConflict = REPLACE)
    suspend fun addNoteEntity(noteEntity: NoteEntity)
    @Query("SELECT * FROM note WHERE noteId = :id")
    suspend fun getNoteEntity(id:Long): NoteEntity?
    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntity():List<NoteEntity>
    @Delete
    suspend fun removeNoteEntity(noteEntity: NoteEntity)
}