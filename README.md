# ExpandableRecyclerView
implemention of ExpandableRecyclerView for android

#Samples
![preview 1](https://github.com/ayalma/ExpandableRecyclerView/blob/master/images/device-2016-05-03-110818.png)
![gif preview](https://github.com//ayalma/ExpandableRecyclerView/blob/master/images/output.gif)

### [Installation]
for importing this library in your android studio 
first add jitpack repository to your root level gradle file like below.

```
allprojects {
    repositories {
        // ... other repo list e.g jcenter or mavenCentral
        maven { url "https://jitpack.io" }
    }
}
```
then add this ```     compile 'com.github.ayalma:ExpandableRecyclerView:0.2.0' ``` to your app level gradle file as below.

```
dependencies {
   // other dependencies name ....
    compile 'com.github.ayalma:ExpandableRecyclerView:0.1.0'
}
```
###Usage
1) add this code to layout as expandableRecycelrView :
```
  <ayalma.ir.expandablerecyclerview.ExpandableRecyclerView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/purchase_list"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_marginLeft="16dp"
    android:layout_marginRight="16dp"
    android:layout_marginTop="16dp"
    app:layoutManager="LinearLayoutManager"
    tools:context=".Ui.MainActivity"
    tools:listitem="@layout/exr_group" />
```

2) create xml file for subitem rows.

``` 
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:orientation="horizontal"
              android:padding="@dimen/standard_material_padding">

    <TextView android:id="@+id/item_name"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:layout_weight="1"
              android:textSize="@dimen/standard_text_size"
              android:textStyle="bold"/>


</LinearLayout>

```
3) create adapter class for expandable recycelr view like below code.

```
public class PurchaseItemRecyclerViewAdapter extends ExpandableRecyclerView.Adapter<PurchaseItemRecyclerViewAdapter.ChildViewHolder,ExpandableRecyclerView.SimpleGroupViewHolder,String,String>
{


    @Override
    public int getGroupItemCount() {
        return 10;
    }

    @Override
    public int getChildItemCount(int i) {
        return 3;
    }

    @Override
    public String getGroupItem(int i) {
        return "group :" + i;
    }

    @Override
    public String getChildItem(int group, int child) {
        return "group: " + group +"item: "+ child;
    }

    @Override
    protected ExpandableRecyclerView.SimpleGroupViewHolder onCreateGroupViewHolder(ViewGroup parent)
    {
        return new ExpandableRecyclerView.SimpleGroupViewHolder(parent.getContext());
    }

    @Override
    protected ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType)
    {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.purchase_list_content,parent,false);
        return new ChildViewHolder(rootView);
    }

    @Override
    public void onBindGroupViewHolder(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        super.onBindGroupViewHolder(holder, group);
        holder.setText(getGroupItem(group));

    }

    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int group, int position)
    {
        super.onBindChildViewHolder(holder, group, position);
        holder.name.setText(getChildItem(group,position));
    }

    @Override
    public int getChildItemViewType(int i, int i1) {
        return 1;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        public ChildViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}

```

5) and in the end setup ExpandableRecyclerView like that:

```
   View eRecyclerView = rootView.findViewById(R.id.purchase_list);
   PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(); // purchaseItemAdapter
   eRecyclerView.setAdapter(mPIAdapter);
```

### Contributors
fill free to add issues or Pull requests


### License
```
Copyright 2015 Ali Mohammadi 'ayalma'

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
