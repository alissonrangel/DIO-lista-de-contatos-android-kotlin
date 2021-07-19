package life.alissonescorcio.listadecontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    //resp por criar cada item visual da tela, mas ainda sem popular
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        //inflar -> dizer quem é meu layout que vai ser resp por desenhar cada item da tela
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    //ler o seu item no array e o popula no recyvlerView
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val tvPhotograph: ImageView = itemView.findViewById(R.id.iv_photo)

        fun bind(contact: Contact){
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }

}