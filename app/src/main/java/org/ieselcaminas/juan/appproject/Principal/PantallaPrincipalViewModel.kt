package org.ieselcaminas.juan.appproject.Principal

import androidx.lifecycle.*
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Job


class PantallaPrincipalViewModel() : ViewModel() {

    private var viewModelJob = Job()

    var db = FirebaseFirestore.getInstance()

    lateinit var placesLiveData: MutableLiveData<MutableList<DocumentSnapshot>>

    var places = db.collection("places").get().result?.documents
        set(value) {
            placesLiveData.value = value
        }



}