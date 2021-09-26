package sec.dev.unitNote.framework.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sec.dev.core.data.Note
import sec.dev.core.repository.NoteRepository
import sec.dev.core.usecase.AddNote
import sec.dev.core.usecase.GetAllNote
import sec.dev.core.usecase.GetNote
import sec.dev.core.usecase.RemoveNote
import sec.dev.unitNote.framework.datasource.RoomNoteDataSource
import sec.dev.unitNote.framework.usecases.UseCases
import sec.dev.utility.constansproperties.CompareConstant

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private  val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository:NoteRepository = NoteRepository(RoomNoteDataSource(application))

    val useCases:UseCases= UseCases(
        AddNote(repository),
        GetAllNote(repository),
        GetNote(repository),
        RemoveNote(repository)
    )
    val saved =MutableLiveData<Boolean>()

    fun saveNote(note:Note){
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(CompareConstant.TrueConstant)
        }
    }
}