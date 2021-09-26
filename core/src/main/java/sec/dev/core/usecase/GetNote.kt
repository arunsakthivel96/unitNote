package sec.dev.core.usecase

import sec.dev.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id:Long) = this.noteRepository.getNote(id)
}