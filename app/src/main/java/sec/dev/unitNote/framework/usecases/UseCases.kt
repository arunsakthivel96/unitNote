package sec.dev.unitNote.framework.usecases

import sec.dev.core.usecase.AddNote
import sec.dev.core.usecase.GetAllNote
import sec.dev.core.usecase.GetNote
import sec.dev.core.usecase.RemoveNote

data class UseCases (
    val addNote: AddNote,
    val getAllNote: GetAllNote,
    val getNote: GetNote,
    val removeNote: RemoveNote
    )
