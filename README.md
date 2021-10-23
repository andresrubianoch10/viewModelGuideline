View Model
https://docs.google.com/document/d/1lL2tfPgtVDus5gZtDAG7yvD1bCGKkTYjxZsPul6MvcE/edit#

First case is when we don’t need to send params to the view model
In Fragment

//Import the view model dependency
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'

private lateinit var viewModel: GameViewModel

(onCreateView)
viewModel =     ViewModelProvider(this).get(GameViewModel::class.java)

//Create view Model class
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
   init {  ...   }

    override fun onCleared() {
       super.onCleared()
   }
}


Second case is when we need to send a param to the view model; so, we need to implement the Factory Method Pattern which allow us to instantiate the view model correctly.

//Create View MOdel with params
class GameViewModel(val score: Int): ViewModel() { … }

//Create View MOdel with params
class ScoreViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
   override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
           return ScoreViewModel(finalScore) as T
       }
       throw IllegalArgumentException("Unknown ViewModel class")
   }
}
//Intantiate both in UI Controller (View)
private lateinit var viewModel: ScoreViewModel
private lateinit var viewModelFactory: ScoreViewModelFactory

viewModelFactory =
  ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(requireArguments()).score)

viewModel = ViewModelProvider(this, viewModelFactory)
   .get(ScoreViewModel::class.java)

