package sec.dev.unitNote.framework.datasource

import android.content.Context
import sec.dev.core.data.Note
import sec.dev.core.repository.NoteDataSource
import sec.dev.unitNote.framework.database.DataBaseService
import sec.dev.unitNote.framework.database.NoteEntity

class RoomNoteDataSource(context: Context):NoteDataSource {

    val noteDao = DataBaseService.getInstance(context).noteDao()
    override suspend fun addNote(note: Note) =noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun getNote(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAllNote() = noteDao.getAllNoteEntity().map { it.toNote() }

    override suspend fun removeNote(note: Note)  =noteDao.removeNoteEntity(NoteEntity.fromNote(note))

}