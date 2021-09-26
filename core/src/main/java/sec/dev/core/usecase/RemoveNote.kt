package sec.dev.core.usecase

import sec.dev.core.data.Note
import sec.dev.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = this.noteRepository.removeNote(note)
}