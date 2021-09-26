package sec.dev.core.repository

import sec.dev.core.data.Note

interface NoteDataSource {
    suspend fun addNote(note:Note)
    suspend fun getNote(id:Long): Note?
    suspend fun getAllNote():List<Note>
    suspend fun removeNote(note: Note)
}