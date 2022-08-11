//package com.naufal.mydiary10119259;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.Layout;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.naufal.mydiary10119259.databinding.ActivityMainBinding;
//
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//    Toolbar toolbar;
//    RecyclerView recyclerView;
//    Adapter adapter;
//    List<Note> notes;
////    ActivityMainBinding binding;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
////        binding = ActivityMainBinding.inflate(getLayoutInflater());
//
//        setContentView(R.layout.activity_main); //Diubah
//
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
//
//        // note selected
//        bottomNavigationView.setSelectedItemId(R.id.note);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.profile:
//                        startActivity(new Intent(getApplicationContext()
//                                ,Profile.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                    case R.id.note:
//                        return true;
//                    case R.id.info:
//                        startActivity(new Intent(getApplicationContext()
//                                ,Info.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                }
//                return false;
//            }
//        });
//
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        NoteDatabase db = new NoteDatabase(this);
//        notes = db.getNotes();
//        recyclerView = findViewById(R.id.listNotes);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new Adapter(this,notes);
//        recyclerView.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.add_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.add) {
//            Intent i = new Intent(this,AddNote.class);
//            startActivity(i);
//            Toast.makeText(this, "Add btn work", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}