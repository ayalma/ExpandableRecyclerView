package ayalma.ir.sample;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

/**
 * Created by alimohammadi on 2015-05-09.
 *
 * @author alimohammadi.
 */
public class ExpandableTestAdapter extends ExpandableRecyclerView.Adapter<ExpandableTestAdapter.ChildViewHolder, ExpandableRecyclerView.SimpleGroupViewHolder, String, String> {

    public ExpandableTestAdapter() {
    }


    @Override
    public int getGroupItemCount() {
        return 6;
    }

    @Override
    public int getChildItemCount(int group) {
        return group+1;
    }

    @Override
    public String getGroupItem(int position) {
        return "group :" + position;
    }

    @Override
    public String getChildItem(int group, int position)
    {
        return "group : "+ group + " item" + position;
    }

    @Override
    protected ExpandableRecyclerView.SimpleGroupViewHolder onCreateGroupViewHolder(ViewGroup parent) {
        return new ExpandableRecyclerView.SimpleGroupViewHolder(parent.getContext());
    }

    @Override
    protected ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_drawer, parent, false);
        return new ChildViewHolder(view);
    }

    @Override
    public int getChildItemViewType(int group, int position) {
        return 1;
    }

    @Override
    public void onBindGroupViewHolder(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        super.onBindGroupViewHolder(holder, group);
        holder.setText(getGroupItem(group));
    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int group, final int position) {
        super.onBindChildViewHolder(holder, group, position);
        holder.tv.setText(getChildItem(group, position));
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv;

        public ChildViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
        }
    }

}
