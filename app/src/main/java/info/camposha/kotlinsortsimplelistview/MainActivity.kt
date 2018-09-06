package info.camposha.kotlinsortsimplelistview


import android.app.Activity
import android.os.Bundle
import android.widget.*
import java.util.*

class MainActivity : Activity() {

    private var myListView: ListView? = null
    private var mySortButton: Button? = null
    private var galaxies = arrayOf("Sombrero", "Cartwheel", "Pinwheel", "StarBust", "Whirlpool", "Ring Nebular", "Own Nebular", "Centaurus A", "Virgo Stellar Stream", "Canis Majos Overdensity", "Mayall's Object", "Leo", "Milky Way", "IC 1011", "Messier 81", "Andromeda", "Messier 87")
    private var sortAscending = true
    private var galaxiesList = Arrays.asList(*galaxies)

    /*
    Sort ListView in ascending and descending manner
     */
    private fun sortData() {
        if (sortAscending) Collections.sort(galaxiesList)
        else

			Collections.reverse(galaxiesList)

        sortAscending = !sortAscending
        myListView!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, galaxiesList)
		myListView!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l -> Toast.makeText(this@MainActivity, galaxiesList[i], Toast.LENGTH_SHORT).show() }
    }

    /*
    Initialize widgets
     */
    private fun initializeViews() {
        myListView = findViewById(R.id.myListView)
        //with arrayadapter you have to pass a textview as a resource, and that is simple_list_item_1
        myListView!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, galaxies)


        mySortButton = findViewById(R.id.mySortBtn)
        mySortButton!!.setOnClickListener { sortData() }
    }

    /*
    When activity is create
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }
}
