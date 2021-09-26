package sec.dev.core.usecase

import sec.dev.core.repository.NoteRepository

class GetAllNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() = this.noteRepository.getAllNote()
}