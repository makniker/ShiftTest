package makniker.shifttest.presentation.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import makniker.shifttest.R

class UserListAdapter(
    private val clickListener: (UserUIListModel) -> Unit
) : ListAdapter<UserUIListModel, UserListAdapter.UserViewHolder>(DIFF_UTIL) {

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<UserUIListModel>() {

            override fun areItemsTheSame(
                oldItem: UserUIListModel, newItem: UserUIListModel
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: UserUIListModel, newItem: UserUIListModel
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(currentList[position], clickListener)
    }

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.picture)
        private val name = view.findViewById<TextView>(R.id.name)
        private val address = view.findViewById<TextView>(R.id.address)
        private val phone = view.findViewById<TextView>(R.id.phone)

        fun bind(item: UserUIListModel, clickListener: (UserUIListModel) -> Unit) {
            Glide.with(imageView).load(item.picture).into(imageView)
            name.text = item.name
            address.text = item.location
            phone.text = item.phone
            itemView.setOnClickListener { clickListener(item) }
        }
    }

}