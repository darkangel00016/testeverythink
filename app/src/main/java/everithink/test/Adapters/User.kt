package everithink.test.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import everithink.test.Listeners.OnItemUserClick
import everithink.test.R



class User(private var mItems: ArrayList<everithink.test.models.User>, val mListener: OnItemUserClick): RecyclerView.Adapter<User.MyViewHolder>() {

    class MyViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {

        val textView: TextView
        val imageView: CircleImageView

        init {
            textView = itemView.findViewById(R.id.textView)
            imageView = itemView.findViewById(R.id.imageView)
        }

        fun bind (user: everithink.test.models.User, listener: OnItemUserClick) {
            textView.text = user.name.getName()
            Picasso.get()
                .load(user.picture.thumbnail)
                .into(imageView)
            itemView.setOnClickListener {
                listener.onItemClicked(user)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mItems.get(position), mListener)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(items: ArrayList<everithink.test.models.User>) {
        mItems.clear()
        mItems.addAll(items)
        notifyDataSetChanged()
    }

}