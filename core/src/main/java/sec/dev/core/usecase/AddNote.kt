package sec.dev.core.usecase

import sec.dev.core.data.Note
import sec.dev.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}