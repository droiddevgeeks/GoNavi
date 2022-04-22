package com.example.gonavi.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubdomain.IClosedMr
import com.example.gonavi.databinding.MergeRequestItemBinding
import com.example.gonavi.helper.loadImage

class MergeRequestAdapter : RecyclerView.Adapter<MergeRequestAdapter.ItemViewHolder>() {

    private val closedMrList: MutableList<IClosedMr> by lazy { mutableListOf() }
    internal fun updateData(closedMrList: List<IClosedMr>) {
        this.closedMrList.clear()
        this.closedMrList.addAll(closedMrList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val dataBinding = MergeRequestItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ItemViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(closedMrList[position])
    }

    override fun getItemCount(): Int {
        return closedMrList.size
    }

    class ItemViewHolder(private var itemBinding: MergeRequestItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(mr: IClosedMr) {
            itemBinding.closedMr = mr
            itemBinding.userProfileImage.loadImage(mr.userData?.userImage)
        }
    }

}