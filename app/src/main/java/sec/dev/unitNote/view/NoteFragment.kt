package sec.dev.unitNote.view

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_note.*
import sec.dev.core.data.Note
import sec.dev.unitNote.R
import sec.dev.unitNote.framework.viewmodel.NoteViewModel
import sec.dev.utility.constansproperties.NumericConstant


class NoteFragment : Fragment() {

private lateinit var  viewModel:NoteViewModel
private  var currentNote = Note("","",0L,0L)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NoteViewModel::class.java)
        checkButtonView.setOnClickListener {
            if(titleEditTextView.text.toString() != "" ||contentEditTextView.text.toString() != ""){
                val time:Long = System.currentTimeMillis()
                currentNote.title = titleEditTextView.text.toString()
                currentNote.content = contentEditTextView.text.toString()
//                currentNote.creationTime = time
                currentNote.updateTime = time
                if(currentNote.id  == 0L){
                    currentNote.creationTime = time
                }
                viewModel.saveNote(currentNote)
            }else{
                Navigation.findNavController(it).popBackStack()
            }
        }
        observableViewModel()
    }
    private fun observableViewModel(){
    viewModel.saved.observe(viewLifecycleOwner, Observer {
        if(it){
        Toast.makeText(context,"Done!", Toast.LENGTH_SHORT).show()
            hideKeyBoard()
            Navigation.findNavController(titleEditTextView).popBackStack()
        }else{
            Toast.makeText(context,"Some thing wrong!", Toast.LENGTH_SHORT).show()
        }
    })
    }
    private fun hideKeyBoard(){
        val keyBoardContext = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        keyBoardContext.hideSoftInputFromWindow(titleEditTextView.windowToken,NumericConstant.NumberZeroConstant)
    }

}