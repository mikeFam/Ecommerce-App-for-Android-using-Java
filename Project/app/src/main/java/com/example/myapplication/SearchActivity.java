package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.models.Brand;
import com.example.myapplication.models.Shoe;
import com.example.myapplication.DataProvider;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    ArrayList<Shoe> shoeList;
    GridView gridView;
    CustomAdaptor customAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        shoeList = new ArrayList<Shoe>();

        gridView = findViewById(R.id.gridView);
        shoeList = DataProvider.generateData();

        customAdaptor = new CustomAdaptor(shoeList, this);

        gridView.setAdapter(customAdaptor);


        /*-----------------------------Bottom Navigation Bar------------------------------------*/
        // Initialize and Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.browse);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity (new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.browse:
                        return true;
                    case R.id.cart:
                        startActivity (new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }

        });
        /*-----------------------------Bottom Navigation Bar End------------------------------------*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.search_view);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdaptor.getFilter().filter(newText);

                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.search_view) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class CustomAdaptor extends BaseAdapter implements Filterable {

        private List<Shoe> shoeModelList;
        private List<Shoe> shoeModelListFiltered;
        private Context context;

        public CustomAdaptor(List<Shoe> shoeModelList, Context context) {
            this.shoeModelList = shoeModelList;
            this.shoeModelListFiltered = shoeModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return shoeModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.search_list,null);

            ImageView imageview = view.findViewById(R.id.image);
            TextView shoeNames = view.findViewById(R.id.name);
            TextView shoePrices = view.findViewById(R.id.price);

            imageview.setImageResource(shoeModelListFiltered.get(position).getImage());
            shoeNames.setText(shoeModelListFiltered.get(position).getName());
            shoePrices.setText("$" + String.valueOf(shoeModelListFiltered.get(position).getPrice()));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("name",shoeModelListFiltered.get(position).getName());
                    intent.putExtra("image",shoeModelListFiltered.get(position).getImage());
                    intent.putExtra("price",shoeModelListFiltered.get(position).getPrice());
                    intent.putExtra("photos",shoeModelListFiltered.get(position).getPhotos());
                    intent.putExtra("brand",shoeModelListFiltered.get(position).getBrand());
                    intent.putExtra("description",shoeModelListFiltered.get(position).getDescription());
                    context.startActivity(intent);
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();

                    if(constraint == null || constraint.length() == 0) {
                        filterResults.count = shoeModelList.size();
                        filterResults.values = shoeModelList;
                    } else {
                        String searchStr = constraint.toString().toLowerCase();
                        List<Shoe> resultData = new ArrayList<>();

                        for(Shoe shoe:shoeModelList){
                            if (shoe.getName().toLowerCase().contains(searchStr) || shoe.getBrand().toLowerCase().contains(searchStr)) {
                                resultData.add(shoe);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }

                    if(filterResults.count == 0) {
                        Toast message = Toast.makeText(SearchActivity.this, "No Item Found",Toast.LENGTH_SHORT);
                        message.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                        message.show();
                    }

                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    shoeModelListFiltered = (List<Shoe>) results.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }
    }

    private String getIncomingIntent(){
        String brandName = null;
        if(getIntent().hasExtra("name")){
            brandName = getIntent().getStringExtra("name");
        }
        return brandName;
    }

}