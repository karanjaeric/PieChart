package com.thepensionapp.piechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class MainActivity extends AppCompatActivity {
    String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};
    String[][] spaceProbes;
//    static String[] spaceProbeHeaders={"No","Name","Propellant","Destination"};
//    static String[][] spaceProbes= {
//            {"1", "Pioneer", "Chemical", "Jupiter"},
//
//            {"2", "Voyager", "Plasma", "Mars"},
//
//            {"3", "Monnet", "Disel", "Moon"},
//
//            {"4", "Curiosity", "Solar", "Venus"},
//
//            {"5", "Apollo", "Anti-matter", "Andromenda"},
//
//            {"6", "Casini", "Chemical", "Saturn"}
//
//    };

   // PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TableView<String[]> tableView=(TableView<String[]>)findViewById(R.id.tableView);
        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        //populate data
        populateData();
        //adapters
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this,spaceProbeHeaders));
        tableView.setColumnCount(4);
        tableView.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this,spaceProbes));

        //table listeners
        tableView.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
                Toast.makeText(MainActivity.this,clickedData[1],Toast.LENGTH_SHORT).show();

            }
        });

//        pieChart=(PieChart)findViewById(R.id.piechart);
//
//        List<PieEntry> entries = new ArrayList<>();
//
//        entries.add(new PieEntry(18.5f, "Green"));
//        entries.add(new PieEntry(26.7f, "Yellow"));
//        entries.add(new PieEntry(24.0f, "Red"));
//        entries.add(new PieEntry(30.8f, "Blue"));
//
//        PieDataSet set = new PieDataSet(entries, "Beneficiaries Allocation");
//        set.setColors(ColorTemplate.COLORFUL_COLORS);
//
//        PieData data = new PieData(set);
//        pieChart.setData(data);
//        pieChart.animateY(2000);
//        pieChart.invalidate(); // refresh
    }
    private void populateData(){

        SpaceProbe spaceProbe=new SpaceProbe();
        ArrayList<SpaceProbe>spaceProbeslist=new ArrayList<>();

        spaceProbe.setId("1");
        spaceProbe.setName("Apolo");
        spaceProbe.setPropellant("Solar");
        spaceProbe.setDestination("Mars");
        spaceProbeslist.add(spaceProbe);

        spaceProbe=new SpaceProbe();
        spaceProbe.setId("2");
        spaceProbe.setName("Pioneer");
        spaceProbe.setPropellant("Chemical");
        spaceProbe.setDestination("Jupiter");
        spaceProbeslist.add(spaceProbe);

        spaceProbe=new SpaceProbe();
        spaceProbe.setId("3");
        spaceProbe.setName("Monet");
        spaceProbe.setPropellant("Anti-Matter");
        spaceProbe.setDestination("Moon");
        spaceProbeslist.add(spaceProbe);

        spaceProbe=new SpaceProbe();
        spaceProbe.setId("4");
        spaceProbe.setName("Casini");
        spaceProbe.setPropellant("Disel");
        spaceProbe.setDestination("Saturn");
        spaceProbeslist.add(spaceProbe);

        spaceProbe=new SpaceProbe();
        spaceProbe.setId("5");
        spaceProbe.setName("Apollo2");
        spaceProbe.setPropellant("Chemical");
        spaceProbe.setDestination("Venus");
        spaceProbeslist.add(spaceProbe);

        spaceProbe=new SpaceProbe();
        spaceProbe.setId("6");
        spaceProbe.setName("AlexanderGreat");
        spaceProbe.setPropellant("Chemical");
        spaceProbe.setDestination("Mercury");
        spaceProbeslist.add(spaceProbe);
        spaceProbes=new String[spaceProbeslist.size()][4];

        for(int i=0;i<spaceProbeslist.size();i++){

            spaceProbes[i][0]=spaceProbeslist.get(i).getId();
            spaceProbes[i][1]=spaceProbeslist.get(i).getName();
            spaceProbes[i][2]=spaceProbeslist.get(i).getPropellant();
            spaceProbes[i][3]=spaceProbeslist.get(i).getDestination();
        }



    }
}
