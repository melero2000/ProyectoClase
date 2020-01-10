package org.ieselcaminas.juan.appproject.Principal
//
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import org.ieselcaminas.juan.appproject.R
import org.ieselcaminas.juan.appproject.databinding.PlacesItemBinding

class PlacesListAdapter : ListAdapter<DocumentSnapshot, ViewHolder>(SleepNightDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //el item que tendra que mostrar (es la lista con la posicion que recibimos)
        val item = getItem(position)
        holder.bind(item)
    }

}

/**
 * ViewHolder that holds a single [TextView].
 *
 * A ViewHolder holds a view for the [RecyclerView] as well as providing additional information
 * to the RecyclerView such as where on the screen it was last drawn during scrolling.
 */
//class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

//si en el layout tenemos mas de un elemento al viewHolder le pasaremos un View entero
class ViewHolder private constructor(val binding: PlacesItemBinding) : RecyclerView.ViewHolder(binding.root) {
    //ESTA FUNCIONESTABA EN EL onCreateViewHolder
    //esto lo hemos creado al extraer la funcion hacemos alt enter en from y le damos a noseq companionobject
    companion object {
        //esto estaba SIN FUNCION en el onCreateViewHolder y lo hemos extraido
        fun from(parent: ViewGroup): ViewHolder {
            //siempre sera parent.context
            val layoutInflater = LayoutInflater.from(parent.context)
            //el item del recycler----parent---false-- solo cambiamos el item y el AS dependiendo de lo que contenga el item (SI ES UN VIEW NO PONEMOS CAST)
            val binding = PlacesItemBinding.inflate(layoutInflater, parent,false)
            //devolvemos el tipo de recycler que sera la clase que hemos creado con el textview
            return ViewHolder(binding)
        }
    }

    //ESTA FUNCION ESTABA EN EL EN onBindViewHolder, LA HEMOS COGIDO Y CON LA FUNCIONALIDAD DE ANDROID LA HEMOS EXTRAIDO, Y LUEGO AL PARAMETRO HOLDER QUE SE LE PASABA HEMOS HECHO CONTROL+ENTER Y LE HEMOS DADO A LA PRIMERA OPCION, LUEGO LO HEMOS TRAIDO A ESTA CLASE Y HEMOS BORRADO LO REDUMNDATE y quitado PRIVATE PARA QUE ARRIBA FUNCIONE EN EL onBindViewHolder
    fun bind(item: DocumentSnapshot) {
        val res = itemView.context.resources


    }
}


//SIEMPRE SERA IGUAL
//esta clase la usaremos para que detecte los cambios de la lista y notificara al recycler y modificara lo que se haya modificado
class SleepNightDiffCallback : DiffUtil.ItemCallback<DocumentSnapshot>() {

    //compara los identificadores para ver si son el mismo item o no, si tienen el mismo id return true sino false
    override fun areItemsTheSame(oldItem: DocumentSnapshot, newItem: DocumentSnapshot): Boolean {
        return oldItem.id == newItem.id
    }

    //compara el contenido de los items, si es el mismo return true sino false
    override fun areContentsTheSame(oldItem: DocumentSnapshot, newItem: DocumentSnapshot): Boolean {
        return oldItem == newItem // como es un dataclass comparara campo a campo
    }

}