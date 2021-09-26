package sec.dev.core.repository

import sec.dev.core.data.Note

class NoteRepository(private  val dataSource: NoteDataSource) {
    suspend fun addNote(note: Note) = this.dataSource.addNote(note)
    suspend fun getNote(id:Long) = this.dataSource.getNote(id)
    suspend fun getAllNote() = this.dataSource.getAllNote()
    suspend fun removeNote(note: Note) = this.dataSource.removeNote(note)
}